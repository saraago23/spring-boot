package com.akademia.detyra2.service;

import com.akademia.detyra2.entity.PostCategory;

public interface PostCategoryService {
    PostCategory getPostGategoryByPostId(Long postId);

    PostCategory getPostCategoryByPostIdAndCategoryId(Long postId, Long categoryId);
}