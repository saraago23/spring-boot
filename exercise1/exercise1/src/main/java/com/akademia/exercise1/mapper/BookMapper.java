package com.akademia.exercise1.mapper;

import com.akademia.exercise1.entity.Author;
import com.akademia.exercise1.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setPublicationYear(rs.getDate("publication_year") != null ? rs.getDate("publication_year").toLocalDate() : null);

        Author author = new Author();
        author.setId(rs.getInt("author_id"));
        author.setAuthorName(rs.getString("author_name"));
        author.setBirthDate(rs.getDate("birth_date") != null ? rs.getDate("birth_date").toLocalDate() : null);

        book.setAuthor(author);

        return book;
    }
}


