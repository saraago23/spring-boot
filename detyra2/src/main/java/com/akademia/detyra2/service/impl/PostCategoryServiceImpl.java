package com.akademia.detyra2.service.impl;

import com.akademia.detyra2.entity.PostCategory;
import com.akademia.detyra2.repository.PostCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.akademia.detyra2.service.PostCategoryService;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {
    @Autowired
    private PostCategoryDAO postCategoryDAO;

    @Override
    public PostCategory getPostGategoryByPostId(Long postId) {
        return postCategoryDAO.getPostGategoryByPostId(postId);
    }

    @Override
    public PostCategory getPostCategoryByPostIdAndCategoryId(Long postId, Long categoryId) {
        return postCategoryDAO.getPostCategoryByPostIdAndCategoryId(postId, categoryId);
    }
}
