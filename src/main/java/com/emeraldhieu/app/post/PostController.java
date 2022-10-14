package com.emeraldhieu.app.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> listPosts() {
        return postService.getPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
                       @RequestBody Post post) {
        return postService.createPost(authorization, post);
    }
}
