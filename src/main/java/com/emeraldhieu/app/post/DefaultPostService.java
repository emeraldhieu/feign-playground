package com.emeraldhieu.app.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultPostService implements PostService {

    private final PostClient postClient;

    @Override
    public List<Post> getPosts() {
        return postClient.getPosts().getPosts();
    }

    @Override
    public Post createPost(String authorization, Post post) {
        return postClient.createPost(authorization, post);
    }
}
