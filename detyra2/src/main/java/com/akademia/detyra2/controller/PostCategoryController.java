package com.akademia.detyra2.controller;

import com.akademia.detyra2.entity.PostCategory;
import com.akademia.detyra2.service.impl.PostCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post-categories")
public class PostCategoryController {
    @Autowired
    private PostCategoryServiceImpl postCategoryService;

    @GetMapping
    public ResponseEntity<List<PostCategory>> getPostCategories() throws Exception {
        return ResponseEntity.ok(postCategoryService.showAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PostCategory>> getPostCategoryById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(postCategoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PostCategory> addPostCategory(@RequestBody PostCategory postCategory) throws Exception {
        return ResponseEntity.ok(postCategoryService.save(postCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostCategory> updatePostCategory(@PathVariable Long id, @RequestBody PostCategory postCategory) throws Exception {
        return ResponseEntity.ok(postCategoryService.save(postCategory));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostCategoryById(@PathVariable Integer id) throws Exception {
        postCategoryService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

}
