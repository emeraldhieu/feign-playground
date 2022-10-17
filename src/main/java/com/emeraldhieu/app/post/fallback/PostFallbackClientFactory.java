package com.emeraldhieu.app.post.fallback;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostFallbackClientFactory implements FallbackFactory<PostFallbackClient> {

    private final PostFallback postFallback;

    @Override
    public PostFallbackClient create(Throwable cause) {
        return new PostFallbackClient(postFallback, cause);
    }
}