package com.emeraldhieu.app.comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Comment> failToGetComments() {
        return commentClient.getComments().getComments();
    }
}
