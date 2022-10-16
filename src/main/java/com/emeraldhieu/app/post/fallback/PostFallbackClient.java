package com.emeraldhieu.app.post.fallback;

import com.emeraldhieu.app.post.Post;
import com.emeraldhieu.app.post.PostClient;
import com.emeraldhieu.app.post.PostResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
public class PostFallbackClient implements PostClient {

    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;
    private final Throwable cause;

    @Override
    public PostResponse getPosts() {
        throw new NoFallbackAvailableException("Boom!", cause);
    }

    @Override
    public Post createPost(String authorization, Post post) {
        throw new NoFallbackAvailableException("Boom!", cause);
    }

    @Override
    public PostResponse failToGetPosts() {
        return fallbackToLatestPosts();
    }

    private PostResponse fallbackToLatestPosts() {
        try (InputStream inputStream = resourceLoader.getResource("classpath:default/latestPosts.json").getInputStream()) {
            return objectMapper.readValue(inputStream, PostResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read default posts", e);
        }
    }
}