package com.akademia.detyra2.repository.impl;

import com.akademia.detyra2.entity.Category;
import com.akademia.detyra2.entity.PostCategory;
import com.akademia.detyra2.exception.CategoryNotFoundException;
import com.akademia.detyra2.mapper.CategoryMapper;
import com.akademia.detyra2.repository.BaseDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository

public class CategoryDaoImpl implements BaseDAO<Category, Integer> {

    private static Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);
    @PersistenceContext
    private EntityManager em;

    @Override
    public Category save(Category category) throws Exception {
        return em.merge(category);
    }

    @Override
    public Optional<Category> findById(Integer id) throws Exception {
        try {
            var entity = em.find(Category.class, id);
            return entity != null ? Optional.of(entity) : Optional.empty();
        }catch (EmptyResultDataAccessException ex){
            throw new CategoryNotFoundException("Category with id: " + id + " was not found");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
      findById(id).ifPresentOrElse(e->em.remove(e),()->logger.warn("Failed to delete category with ID: " + id));
    }

    @Override
    public List<Category> showAll() throws Exception {
        return em.createNamedQuery(Category.GET_ALL).getResultList();
    }
}
