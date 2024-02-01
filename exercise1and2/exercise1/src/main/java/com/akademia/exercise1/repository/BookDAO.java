package com.akademia.exercise1.repository;

import com.akademia.exercise1.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAllBooks();

    Book getBookById(Integer id);

    Boolean insertBook(Book book);

    Boolean updateBook(Integer id, Book book);
    Boolean deleteBook(Integer id);
}
