package com.akademia.detyra2.repository.impl;

import com.akademia.detyra2.entity.Post;
import com.akademia.detyra2.exception.PostNotFoundException;
import com.akademia.detyra2.mapper.PostMapper;
import com.akademia.detyra2.repository.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class PostDaoImpl implements PostDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String GET_POSTS_Q = "SELECT * FROM posts p JOIN users u ON p.user_id=u.id";
    private static final String GET_POST_BY_ID_Q = "SELECT * FROM posts p JOIN users u ON p.user_id = u.id WHERE p.id = ?";
    private static final String GET_POST_BY_USER_ID_Q = "SELECT * FROM posts p JOIN users u ON p.user_id = u.id WHERE u.id = ?";
    private static final String CREATE_POST_Q = "INSERT INTO posts(title,body,date_created, user_id) VALUES(?,?,?,?)";
    private static final String UPDATE_POST_Q = "UPDATE posts SET title = ?, body = ?, date_modified = ?, user_id=? WHERE id = ?";

    @Override
    public List<Post> getPosts() {
        return jdbcTemplate.query(GET_POSTS_Q, new PostMapper());
    }

    @Override
    public Post getPostsById(Long id) {
        try {
        return jdbcTemplate.queryForObject(GET_POST_BY_ID_Q, new PostMapper(), id);
        }catch(EmptyResultDataAccessException ex){
            throw new PostNotFoundException("Post with id: " + id + " was not found");
        }
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return jdbcTemplate.query(GET_POST_BY_USER_ID_Q, new PostMapper(), userId);
    }

    @Override
    public Boolean createPost(Post post) {
        var create = jdbcTemplate.update(CREATE_POST_Q, new Object[]{post.getTitle(), post.getBody(), post.getDateCreated(), post.getUser().getId()});
        return create == -1 ? false : true;
    }

    @Override
    public Boolean updatePost(Long id, Post post) {
        var update = jdbcTemplate.update(UPDATE_POST_Q, new Object[]{post.getTitle(), post.getBody(), post.getDateModified(), post.getUser().getId(), id});
        return update == -1 ? false : true;
    }
}
