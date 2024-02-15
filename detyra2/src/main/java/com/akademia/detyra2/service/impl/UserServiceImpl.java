package com.akademia.detyra2.service.impl;

import com.akademia.detyra2.entity.User;

import com.akademia.detyra2.repository.impl.UserDaoImpl;
import com.akademia.detyra2.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements BaseService<User, Integer> {


    @Autowired
    private UserDaoImpl userDao;


    @Override
    public User save(User user) throws Exception {
        return userDao.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        userDao.deleteById(id);
    }

    @Override
    public List<User> showAll() throws Exception {
        return userDao.showAll();
    }
}
