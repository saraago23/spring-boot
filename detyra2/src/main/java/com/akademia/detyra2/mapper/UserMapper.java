package com.akademia.detyra2.mapper;


import com.akademia.detyra2.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setDateCreated(rs.getDate("date_created") != null ? rs.getDate("date_created").toLocalDate() : null);
        user.setDateModified(rs.getDate("date_modified") != null ? rs.getDate("date_modified").toLocalDate() : null);

        return user;

    }
}
