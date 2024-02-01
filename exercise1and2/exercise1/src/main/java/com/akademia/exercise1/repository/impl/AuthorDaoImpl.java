package com.akademia.exercise1.repository.impl;

import com.akademia.exercise1.entity.Author;
import com.akademia.exercise1.entity.Book;
import com.akademia.exercise1.mapper.BookMapper;
import com.akademia.exercise1.repository.AuthorDAO;
import com.akademia.exercise1.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_AUTHORS_Q = "SELECT * FROM authors";
    private static final String GET_AUTHOR_BY_ID_Q = "SELECT * FROM authors WHERE id=?";
    private static final String INSERT_AUTHOR_Q = "INSERT INTO authors(author_name,birth_date) VALUES(?,?)";
    private static final String UPDATE_AUTHOR_Q = "UPDATE authors SET author_name = ?, birth_date = ? WHERE id = ?";
    private static final String DELETE_AUTHOR_Q = "DELETE FROM authors WHERE id = ?";

    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(GET_AUTHORS_Q, new BeanPropertyRowMapper<>(Author.class));
    }

    @Override
    public Author getAuthorById(Integer id) {
        return jdbcTemplate.queryForObject(GET_AUTHOR_BY_ID_Q, new BeanPropertyRowMapper<>(Author.class),id);
    }

    @Override
    public Boolean insertAuthor(Author author) {
        var insert = jdbcTemplate.update(INSERT_AUTHOR_Q, new Object[]{author.getAuthorName(),author.getBirthDate()});
        return insert == -1 ? false : true;
    }

    @Override
    public Boolean updateAuthor(Integer id, Author author) {
        var update = jdbcTemplate.update(UPDATE_AUTHOR_Q, new Object[]{author.getAuthorName(),author.getBirthDate(),id});
        return update == -1 ? false : true;
    }

    @Override
    public Boolean deleteAuthor(Integer id) {
        var delete = jdbcTemplate.update(DELETE_AUTHOR_Q, id);
        return delete == -1 ? false : true;
    }
}
