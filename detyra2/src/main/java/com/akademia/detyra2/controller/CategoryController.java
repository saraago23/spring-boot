package com.akademia.detyra2.controller;

import com.akademia.detyra2.entity.Category;
import com.akademia.detyra2.exception.CategoryNotFoundException;
import com.akademia.detyra2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getPostCategories() {
        try {
            return ResponseEntity.ok(categoryService.getCategories());
        }catch (NullPointerException ex){
            throw new CategoryNotFoundException("There are no available categories");
        }
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getPostCategoryById(@PathVariable Long categoryId) {
        try {
            return ResponseEntity.ok(categoryService.getOneCategoryById(categoryId));
        } catch (EmptyResultDataAccessException ex) {
            throw new CategoryNotFoundException("Category with id: " + categoryId + " was not found");
        }
    }

    @PostMapping
    public ResponseEntity<Boolean> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @DeleteMapping("/blog/categories/{categoryId}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }

}
