package com.emeraldhieu.app.post.fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostFallbackClientFactory implements FallbackFactory<PostFallbackClient> {

    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    @Override
    public PostFallbackClient create(Throwable cause) {
        return new PostFallbackClient(resourceLoader, objectMapper, cause);
    }
}