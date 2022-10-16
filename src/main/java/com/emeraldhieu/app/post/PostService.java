package com.emeraldhieu.app.post;

import java.util.List;

public interface PostService {

    List<Post> getPosts();

    Post createPost(String authorization, Post post);

    List<Post> failToGetPosts();
}
