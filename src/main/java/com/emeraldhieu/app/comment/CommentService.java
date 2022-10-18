package com.emeraldhieu.app.comment;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CommentService {

    CompletableFuture<List<Comment>> getComments();

    List<Comment> failToGetComments();
}
