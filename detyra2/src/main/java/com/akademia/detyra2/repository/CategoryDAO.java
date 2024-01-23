package com.akademia.detyra2.repository;

import com.akademia.detyra2.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getCategories();
    List<Category> getCategoryById(Long id);
    Boolean createCategory(Category category);
}
