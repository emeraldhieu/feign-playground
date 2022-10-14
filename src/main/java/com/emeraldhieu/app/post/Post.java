package com.emeraldhieu.app.post;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

@Builder
@Getter
@Jacksonized
public class Post {

    private final int id;
    private final String title;
    private final String body;
    private final int userId;
    private final List<String> tags;
    private final int reactions;
}
