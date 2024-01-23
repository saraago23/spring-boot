package com.akademia.detyra2.mapper;

import com.akademia.detyra2.entity.Category;
import com.akademia.detyra2.entity.Post;
import com.akademia.detyra2.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        category.setDateCreated(rs.getDate("date_created") != null ? rs.getDate("date_created").toLocalDate() : null);
        category.setDateModified(rs.getDate("date_modified") != null ? rs.getDate("date_modified").toLocalDate() : null);


        return category;

    }
}
