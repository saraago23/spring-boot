package com.akademia.detyra2.service.impl;

import com.akademia.detyra2.entity.Category;
import com.akademia.detyra2.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.akademia.detyra2.service.CategoryService;

import java.util.List;

@Service

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> getCategories() {
        return categoryDAO.getCategories();
    }

    @Override
    public List<Category> getCategoryById(Long id) {
        return categoryDAO.getCategoryById(id);
    }

    @Override
    public Boolean createCategory(Category category) {
        return categoryDAO.createCategory(category);
    }
}
