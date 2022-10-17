package com.emeraldhieu.app.post.fallback;

import com.emeraldhieu.app.post.PostResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * A fallback component for posts.
 */
@Component
@RequiredArgsConstructor
public class PostFallback {

    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    public PostResponse getLatestPosts() {
        try (InputStream inputStream = resourceLoader.getResource("classpath:default/latestPosts.json").getInputStream()) {
            return objectMapper.readValue(inputStream, PostResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read default posts", e);
        }
    }
}
