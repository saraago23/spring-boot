package com.akademia.detyra2.repository.impl;

import com.akademia.detyra2.entity.Category;
import com.akademia.detyra2.mapper.CategoryMapper;
import com.akademia.detyra2.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository

public class CategoryDaoImpl implements CategoryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String GET_CATEGORIES_Q = "SELECT * FROM categories";
    private static final String GET_CATEGORY_BY_ID_Q = "SELECT * FROM categories WHERE id=?";
    private static final String CREATE_CATEGORY_Q = "INSERT INTO categories(name,date_created) VALUES(?,?)";

    @Override
    public List<Category> getCategories() {
        return jdbcTemplate.query(GET_CATEGORIES_Q, new CategoryMapper());
    }

    @Override
    public List<Category> getCategoryById(Long id) {
        return jdbcTemplate.query(GET_CATEGORY_BY_ID_Q, new CategoryMapper(), id);
    }

    @Override
    public Boolean createCategory(Category category) {
        var create = jdbcTemplate.update(CREATE_CATEGORY_Q, new Object[]{category.getName(), category.getDateCreated()});
        return create == -1 ? false : true;
    }
}
