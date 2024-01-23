package com.akademia.detyra2.repository;

import com.akademia.detyra2.entity.PostCategory;

public interface PostCategoryDAO {
    PostCategory getPostGategoryByPostId(Long postId);

    PostCategory getPostCategoryByPostIdAndCategoryId(Long postId, Long categoryId);
}
