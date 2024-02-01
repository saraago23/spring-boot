package com.akademia.exercise1.service.impl;

import com.akademia.exercise1.entity.Author;
import com.akademia.exercise1.repository.AuthorDAO;
import com.akademia.exercise1.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }

    @Override
    public Author getAuthorById(Integer id) {
        return authorDAO.getAuthorById(id);
    }

    @Override
    public Boolean insertAuthor(Author author) {
        return authorDAO.insertAuthor(author);
    }

    @Override
    public Boolean updateAuthor(Integer id, Author author) {
        return authorDAO.updateAuthor(id, author);
    }

    @Override
    public Boolean deleteAuthor(Integer id) {
        return authorDAO.deleteAuthor(id);
    }
}
