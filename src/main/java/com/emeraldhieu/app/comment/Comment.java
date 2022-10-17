package com.emeraldhieu.app.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;

@Builder
@Getter
@Jacksonized
public class Comment {

    private final int id;
    private final String body;
    private final int postId;
    private final Map<String, Object> user;
}
