package com.akademia.detyra2.service.impl;

import com.akademia.detyra2.entity.Category;
import com.akademia.detyra2.repository.impl.CategoryDaoImpl;
import com.akademia.detyra2.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements BaseService<Category, Integer> {
    @Autowired
    private CategoryDaoImpl categoryDao;

    @Override
    public Category save(Category category) throws Exception {
        return categoryDao.save(category);
    }

    @Override
    public Optional<Category> findById(Integer id) throws Exception {
        return categoryDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        categoryDao.deleteById(id);
    }

    @Override
    public List<Category> showAll() throws Exception {
        return categoryDao.showAll();
    }
}
