package com.akademia.detyra2.repository;

import com.akademia.detyra2.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    User getUserById(Long id);
    Boolean createUser(User user);
    Boolean updateUser(Long id, User user);
    Boolean deleteUser(Long id);
    public Integer insertUser(User user);
}
