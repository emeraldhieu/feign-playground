package com.emeraldhieu.app.comment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The first way of using feign that is via Spring Cloud Open Feign.
 */
@FeignClient(value = "comment", url = "https://dummyjson.com")
public interface CommentClient {

    @GetMapping("/comments")
    CommentResponse getComments();

    /**
     * Assuming getting all comments fails due to 500.
     */
    @GetMapping("/http/500")
    CommentResponse failToGetComments();
}
