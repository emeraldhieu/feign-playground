package com.emeraldhieu.app.post;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Getter
@Jacksonized
public class PostResponse {

    private final List<Post> posts;
}
