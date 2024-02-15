package com.akademia.detyra2.repository.impl;

import com.akademia.detyra2.entity.Post;
import com.akademia.detyra2.exception.PostNotFoundException;
import com.akademia.detyra2.mapper.PostMapper;
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

public class PostDaoImpl implements BaseDAO<Post, Integer> {

    private static Logger logger = LoggerFactory.getLogger(PostDaoImpl.class);
    @PersistenceContext
    private EntityManager em;

    @Override
    public Post save(Post post) throws Exception {
        return em.merge(post);
    }

    @Override
    public Optional<Post> findById(Integer id) throws Exception {
        try {
            var entity = em.find(Post.class, id);
            return entity != null ? Optional.of(entity) : Optional.empty();
        }catch (EmptyResultDataAccessException ex){
            throw new PostNotFoundException("Post with id: " + id + " was not found");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        findById(id).ifPresentOrElse(e-> em.remove(e),()-> logger.warn("Failed to delete post with ID: " + id));
    }

    @Override
    public List<Post> showAll() throws Exception {
        return em.createNamedQuery(Post.GET_ALL).getResultList();
    }
}
