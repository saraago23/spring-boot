package com.akademia.detyra2.controller;

import com.akademia.detyra2.entity.User;
import com.akademia.detyra2.exception.UserNotFoundException;
import com.akademia.detyra2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(userService.getUserById(userId));
        }catch(EmptyResultDataAccessException ex ){
            throw new UserNotFoundException ("User with id: " + userId + " was not found");
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.insertUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }


    //TODO
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

}
