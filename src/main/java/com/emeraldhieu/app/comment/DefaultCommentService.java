package com.emeraldhieu.app.comment;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultCommentService implements CommentService {

    private final CommentClient commentClient;

    @Override
    public List<Comment> getComments() {
        return commentClient.getComments().getComments();
    }

    @Override
    @Retryable(value = RuntimeException.class, recover = "commentFallback", backoff = @Backoff(500))
    public List<Comment> failToGetComments() {
        log.info("Retrying to get comments...");
        return commentClient.failToGetComments().getComments();
    }

    @Recover
    public List<Comment> commentFallback(FeignException exception) {
        log.info("Fallbacks to default comments.");
        return List.of(
            Comment.builder()
                .id(42)
                .body("default")
                .user(Map.of(
                    "id", 666,
                    "username", "johndoe"
                ))
                .build()
        );
    }
}
