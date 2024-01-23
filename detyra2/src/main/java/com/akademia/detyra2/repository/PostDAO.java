package com.akademia.detyra2.repository;

import com.akademia.detyra2.entity.Post;

import java.util.List;

public interface PostDAO {
    List<Post> getPosts();
    Post getPostsById(Long id);
    List<Post> getPostsByUserId(Long userId);
    Boolean createPost(Post post);
    Boolean updatePost(Long id, Post user);
}
