package com.akademia.exercise1.service.impl;

import com.akademia.exercise1.entity.Book;
import com.akademia.exercise1.repository.BookDAO;
import com.akademia.exercise1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDAO.getBookById(id);
    }

    @Override
    public Boolean insertBook(Book book) {
        return bookDAO.insertBook(book);
    }

    @Override
    public Boolean updateBook(Integer id, Book book) {
        return bookDAO.updateBook(id,book);
    }

    @Override
    public Boolean deleteBook(Integer id) {
        return bookDAO.deleteBook(id);
    }
}
