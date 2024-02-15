package com.akademia.detyra2.repository.impl;

import com.akademia.detyra2.entity.Post;
import com.akademia.detyra2.entity.PostCategory;
import com.akademia.detyra2.exception.PostNotFoundException;
import com.akademia.detyra2.mapper.PostCategoryMapper;
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
public class PostCategoryImpl implements BaseDAO<PostCategory, Integer> {
    private static Logger logger = LoggerFactory.getLogger(PostCategoryImpl.class);
    @PersistenceContext
    private EntityManager em;

    @Override
    public PostCategory save(PostCategory postCategory) throws Exception {
        return em.merge(postCategory);
    }

    @Override
    public Optional<PostCategory> findById(Integer id) throws Exception {
        try {
            var entity = em.find(PostCategory.class, id);
            return entity != null ? Optional.of(entity) : Optional.empty();
        }catch (EmptyResultDataAccessException ex){
            throw new PostNotFoundException("Post category with id: " + id + " was not found");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        findById(id).ifPresentOrElse(e->em.remove(e),()->logger.warn("Failed to delete post category with ID: " + id));
    }

    @Override
    public List<PostCategory> showAll() throws Exception {
        return em.createNamedQuery(PostCategory.GET_ALL).getResultList();
    }
}
