package com.akademia.exercise1.repository;

import com.akademia.exercise1.entity.Author;
import com.akademia.exercise1.entity.Book;

import java.util.List;

public interface AuthorDAO {
    List<Author> getAllAuthors();

    Author getAuthorById(Integer id);

    Boolean insertAuthor(Author author);

    Boolean updateAuthor(Integer id, Author author);
    Boolean deleteAuthor(Integer id);
}
