package com.akademia.detyra2.controller;

import com.akademia.detyra2.entity.Post;
import com.akademia.detyra2.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @GetMapping()
    public ResponseEntity<List<Post>> getAllPosts() throws Exception {
        return ResponseEntity.ok(postService.showAll());
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(postService.findById(id));
    }


    @PostMapping("/posts/user/{id}")
    public ResponseEntity<Post> addPost(@PathVariable Long id, @RequestBody Post post) throws Exception {
        post.setId(Math.toIntExact(id));
        return ResponseEntity.ok(postService.save(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Integer id) throws Exception {
        postService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }


}
