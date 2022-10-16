package com.emeraldhieu.app.post;

import com.emeraldhieu.app.post.fallback.PostFallbackClientFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * The second way of using Open Feign without Spring.
 */
@FeignClient(value = "post", url = "https://dummyjson.com",
    configuration = PostFeignConfiguration.class,
    fallbackFactory = PostFallbackClientFactory.class
)
public interface PostClient {

    @GetMapping("/posts")
    PostResponse getPosts();

    @PostMapping("/posts/add")
    Post createPost(@RequestHeader("Authorization") String authorization, Post post);

    /**
     * Assuming getting all posts fails due to 500.
     */
    @GetMapping("/http/500")
    PostResponse failToGetPosts();
}
