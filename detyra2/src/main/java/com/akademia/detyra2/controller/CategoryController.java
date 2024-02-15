package com.akademia.detyra2.controller;

import com.akademia.detyra2.entity.Category;
import com.akademia.detyra2.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() throws Exception {
        return ResponseEntity.ok(categoryService.showAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) throws Exception {
        return ResponseEntity.ok(categoryService.save(category));
    }

    @DeleteMapping("/blog/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) throws Exception {
        categoryService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

}
