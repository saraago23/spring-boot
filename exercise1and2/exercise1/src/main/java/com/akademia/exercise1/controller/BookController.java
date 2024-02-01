package com.akademia.exercise1.controller;

import com.akademia.exercise1.entity.Book;
import com.akademia.exercise1.service.AuthorService;
import com.akademia.exercise1.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookController implements CommandLineRunner {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    public static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("These are all the books:{} ", bookService.getAllBooks());

        var book6 = Book.builder()
                .title("New Title")
                .author(authorService.getAuthorById(2))
                .publicationYear(LocalDate.of(1995, 5, 21))
                .build();


        var updatedBook = bookService.getBookById(4);
        updatedBook.setTitle("New title");
        updatedBook.setAuthor(authorService.getAuthorById(5));
        updatedBook.setPublicationYear(LocalDate.now());

        logger.info("This is the book with id: {}, {} ", 2, bookService.getBookById(2));
        logger.info("This is the author with id: {} {} ", 2, authorService.getAuthorById(2));
        logger.info("New book is added: {} ", bookService.insertBook(book6));

        logger.info("Book with id: {} id updated: {} ", 4, bookService.updateBook(4, updatedBook));
        //logger.info("Book with id: {} is deleted: {}", 3, bookService.deleteBook(3));
    }
}
