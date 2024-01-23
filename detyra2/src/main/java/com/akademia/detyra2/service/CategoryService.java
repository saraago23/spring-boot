package com.akademia.detyra2.service;

import com.akademia.detyra2.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    List<Category> getCategoryById(Long id);

    Boolean createCategory(Category category);
}