package com.akademia.detyra2.repository.impl;

import com.akademia.detyra2.entity.User;
import com.akademia.detyra2.exception.UserNotFoundException;
import com.akademia.detyra2.mapper.UserMapper;
import com.akademia.detyra2.repository.UserDAO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_USERS_Q = "SELECT * FROM users";
    private static final String GET_USER_BY_ID_Q = "SELECT * FROM users WHERE id=?";
    private static final String CREATE_USER_Q = "INSERT INTO users(username,email,password,date_created,date_modified) VALUES(?,?,?,?,?)";
    private static final String UPDATE_USER_Q = "UPDATE users SET username = ?, email = ?, password = ?,date_created=?, date_modified = ? WHERE id = ?";
    private static final String DELETE_USER_Q = "DELETE FROM users WHERE id = ?";


    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query(GET_USERS_Q, new UserMapper());
    }

    @Override
    public User getUserById(Long id) {
        try {
            return jdbcTemplate.queryForObject(GET_USER_BY_ID_Q, new UserMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            throw new UserNotFoundException("User with id: " + id + " was not found");
        }
    }

    @Override
    public Boolean createUser(User user) {
        var create = jdbcTemplate.update(CREATE_USER_Q, new Object[]{user.getUsername(), user.getEmail(), user.getPassword(), user.getDateCreated(), user.getDateModified()});
        return create == -1 ? false : true;
    }

    public Integer insertUser(User user) {

        KeyHolder key = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(
                    CREATE_USER_Q, new String[]{"id"});
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setObject(4, user.getDateCreated());
            ps.setObject(5, user.getDateModified());

            return ps;
        }, key);

        return key.getKey().intValue();
    }

    @Override
    public Boolean updateUser(Long id, User user) {
        var update = jdbcTemplate.update(UPDATE_USER_Q, new Object[]{user.getUsername(), user.getEmail(), user.getPassword(), user.getDateCreated(), user.getDateModified(), id});
        return update == -1 ? false : true;
    }

    @Override
    public Boolean deleteUser(Long id) {
        var delete = jdbcTemplate.update(DELETE_USER_Q, new Object[]{id});
        return delete == -1 ? false : true;
    }
}
