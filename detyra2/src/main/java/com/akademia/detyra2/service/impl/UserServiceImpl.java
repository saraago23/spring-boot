package com.akademia.detyra2.service.impl;

import com.akademia.detyra2.entity.User;
import com.akademia.detyra2.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.akademia.detyra2.service.UserService;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public Boolean createUser(User user) {
        return userDAO.createUser(user);
    }

    @Override
    public Boolean updateUser(Long id, User user) {
        return userDAO.updateUser(id,user);
    }

    @Override
    public Boolean deleteUser(Long id) {
        return userDAO.deleteUser(id);
    }
}
