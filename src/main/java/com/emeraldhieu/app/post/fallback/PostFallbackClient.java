package com.emeraldhieu.app.post.fallback;

import com.emeraldhieu.app.post.Post;
import com.emeraldhieu.app.post.PostClient;
import com.emeraldhieu.app.post.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;

@RequiredArgsConstructor
public class PostFallbackClient implements PostClient {

    private final PostFallback postFallback;
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
        return postFallback.getLatestPosts();
    }
}