package com.akademia.detyra2.controller;

import com.akademia.detyra2.entity.Post;
import com.akademia.detyra2.exception.PostNotFoundException;
import com.akademia.detyra2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Post>> getAllPosts(@PathVariable Long userId) {
        return ResponseEntity.ok(postService.getPostsByUserId(userId));
    }

    @GetMapping("/{postId}/post")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostsById(postId));
    }

    //TODO
   /* @GetMapping("/post/user/{userId}")
    public ResponseEntity<UserPostDTO> getPostByUserId(@PathVariable Long userId) {

    }*/
    //TODO
   /* @PostMapping("/post/user/{id}")
    public ResponseEntity<Boolean> addPost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(Math.toIntExact(id));
        return ResponseEntity.ok(postService.createPost(post));
    }*/


}
