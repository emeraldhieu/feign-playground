package com.emeraldhieu.app.comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComments();

    List<Comment> failToGetComments();
}
