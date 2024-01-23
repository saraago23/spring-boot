package com.akademia.detyra2.mapper;


import com.akademia.detyra2.entity.Category;
import com.akademia.detyra2.entity.Post;
import com.akademia.detyra2.entity.PostCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PostCategoryMapper implements RowMapper<PostCategory> {
    @Override
    public PostCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostCategory postCategory = new PostCategory();
        postCategory.setId(rs.getInt("id"));
        postCategory.setDateCreated(rs.getDate("date_created") != null ? rs.getDate("date_created").toLocalDate() : null);
        postCategory.setDateModified(rs.getDate("date_modified") != null ? rs.getDate("date_modified").toLocalDate() : null);

        Post post = new Post();
        post.setId(rs.getInt("id"));
        post.setTitle(rs.getString("title"));
        post.setBody(rs.getString("body"));
        post.setDateCreated(rs.getDate("date_created") != null ? rs.getDate("date_created").toLocalDate() : null);
        post.setDateModified(rs.getDate("date_modified") != null ? rs.getDate("date_modified").toLocalDate() : null);

        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        category.setDateCreated(rs.getDate("date_created") != null ? rs.getDate("date_created").toLocalDate() : null);
        category.setDateModified(rs.getDate("date_modified") != null ? rs.getDate("date_modified").toLocalDate() : null);

        postCategory.setPost(post);
        postCategory.setCategory(category);
        return postCategory;

    }
}
