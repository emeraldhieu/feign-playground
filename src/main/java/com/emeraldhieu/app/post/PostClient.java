package com.emeraldhieu.app.post;

import com.emeraldhieu.app.photo.PhotoFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * The second way of using Open Feign without Spring.
 */
@FeignClient(value = "post", url = "https://dummyjson.com", path = "posts",
    configuration = PostFeignConfiguration.class)
public interface PostClient {

    @GetMapping
    PostResponse getPosts();

    @PostMapping("add")
    Post createPost(@RequestHeader("Authorization") String authorization, Post post);
}
