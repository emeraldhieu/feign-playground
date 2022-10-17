package com.emeraldhieu.app.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Getter
@Jacksonized
public class CommentResponse {

    private final List<Comment> comments;
}
