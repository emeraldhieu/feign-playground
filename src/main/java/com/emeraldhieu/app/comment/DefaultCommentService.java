package com.emeraldhieu.app.comment;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultCommentService implements CommentService {

    private final CommentClient commentClient;

    @Override
    public CompletableFuture<List<Comment>> getComments() {
        // Method #1
//        return CompletableFuture.supplyAsync(() -> {
//            List<Comment> comments = commentClient.getComments().getComments();
//            return comments;
//        });

        // Method #2
//        CompletableFuture<List<Comment>> completableFuture = new CompletableFuture<>();
//
//        Executors.newCachedThreadPool().submit(() -> {
//            Thread.sleep(500);
//            List<Comment> comments = commentClient.getComments().getComments();
//            completableFuture.complete(comments);
//            return null;
//        });
//
//        return completableFuture;

//        // Method #3
//        List<Comment> comments = commentClient.getComments().getComments();
//        return CompletableFuture.completedFuture(comments);

        // Method #4
        CompletableFuture<List<Comment>> future1 = CompletableFuture.supplyAsync(() -> {
            List<Comment> comments = commentClient.getComments(10, 0).getComments();
            return comments;
        });

        CompletableFuture<List<Comment>> future2 = CompletableFuture.supplyAsync(() -> {
            List<Comment> comments = commentClient.getComments(10, 10).getComments();
            return comments;
        });

        List<Comment> comments = Stream.of(future1, future2)
            .map(CompletableFuture::join)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

        return CompletableFuture.completedFuture(comments);
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
