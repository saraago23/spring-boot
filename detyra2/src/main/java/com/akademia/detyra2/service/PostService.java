package com.akademia.detyra2.service;

import com.akademia.detyra2.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();

    Post getPostsById(Long id);

    List<Post> getPostsByUserId(Long userId);

    Boolean createPost(Post post);

    Boolean updatePost(Long id, Post post);
}
