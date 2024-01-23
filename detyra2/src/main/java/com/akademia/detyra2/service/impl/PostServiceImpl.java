package com.akademia.detyra2.service.impl;

import com.akademia.detyra2.entity.Post;
import com.akademia.detyra2.repository.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.akademia.detyra2.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDAO postDAO;

    @Override
    public List<Post> getPosts() {
        return postDAO.getPosts();
    }

    @Override
    public Post getPostsById(Long id) {
        return postDAO.getPostsById(id);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return postDAO.getPostsByUserId(userId);
    }

    @Override
    public Boolean createPost(Post post) {
        return postDAO.createPost(post);
    }

    @Override
    public Boolean updatePost(Long id, Post post) {
        return postDAO.updatePost(id, post);
    }
}
