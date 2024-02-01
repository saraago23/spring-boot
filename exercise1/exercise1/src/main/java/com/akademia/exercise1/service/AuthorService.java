package com.akademia.exercise1.service;

import com.akademia.exercise1.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author getAuthorById(Integer id);

    Boolean insertAuthor(Author author);

    Boolean updateAuthor(Integer id, Author author);
    Boolean deleteAuthor(Integer id);
}
