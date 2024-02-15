package com.akademia.detyra2.repository.impl;

import com.akademia.detyra2.entity.User;
import com.akademia.detyra2.exception.UserNotFoundException;
import com.akademia.detyra2.repository.BaseDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements BaseDAO<User, Integer> {
    private static Logger logger = LoggerFactory.getLogger(User.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public User save(User user) throws Exception {
        return em.merge(user);
    }

    @Override
    public Optional<User> findById(Integer id) throws Exception {
        try {
            var entity = em.find(User.class, id);
            return entity != null ? Optional.of(entity) : Optional.empty();
        }catch (EmptyResultDataAccessException ex){
            throw new UserNotFoundException("User with id: " + id + " was not found");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        findById(id).ifPresentOrElse(e-> em.remove(e),()->logger.warn("Failed to delete user with ID: "+ id));
    }

    @Override
    public List<User> showAll() throws Exception {
        return em.createNamedQuery(User.GET_ALL).getResultList();
    }
}
