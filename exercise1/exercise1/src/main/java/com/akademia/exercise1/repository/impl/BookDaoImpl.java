package com.akademia.exercise1.repository.impl;

import com.akademia.exercise1.entity.Book;
import com.akademia.exercise1.mapper.BookMapper;
import com.akademia.exercise1.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_BOOKS_Q = "SELECT * FROM books b JOIN authors a ON b.author_id=a.id";
    private static final String GET_BOOK_BY_ID_Q = "SELECT * FROM books b JOIN authors a ON b.author_id=a.id WHERE b.id=?";
    private static final String INSERT_BOOK_Q = "INSERT INTO books(title,author_id,publication_year) VALUES(?,?,?)";
    private static final String UPDATE_BOOK_Q = "UPDATE books SET title = ?, author_id = ?, publication_year = ? WHERE id = ?";
    private static final String DELETE_BOOK_Q = "DELETE FROM books WHERE id = ?";

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query(GET_BOOKS_Q, new BookMapper());
    }

    @Override
    public Book getBookById(Integer id) {
        return jdbcTemplate.queryForObject(GET_BOOK_BY_ID_Q, new BookMapper(),id);
    }

    @Override
    public Boolean insertBook(Book book) {
        var insert = jdbcTemplate.update(INSERT_BOOK_Q, new Object[]{book.getTitle(), book.getAuthor().getId(), book.getPublicationYear()});
        return insert == -1 ? false : true;
    }

    @Override
    public Boolean updateBook(Integer id, Book book) {
        var update = jdbcTemplate.update(UPDATE_BOOK_Q, new Object[]{book.getTitle(), book.getAuthor().getId(), book.getPublicationYear(),id});
        return update == -1 ? false : true;
    }

    @Override
    public Boolean deleteBook(Integer id) {
        var delete = jdbcTemplate.update(DELETE_BOOK_Q, id);
        return delete == -1 ? false : true;
    }
}
