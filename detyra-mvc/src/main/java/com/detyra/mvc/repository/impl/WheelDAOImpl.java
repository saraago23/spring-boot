package com.detyra.mvc.repository.impl;

import com.detyra.mvc.dto.Wheel;
import com.detyra.mvc.exception.WheelNotFoundException;
import com.detyra.mvc.repository.WheelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WheelDAOImpl implements WheelDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String GET_WHEELS_Q = "SELECT * FROM car_wheels";
    private static final String GET_WHEEL_BY_ID_Q = "SELECT * FROM car_wheels WHERE id=?";
    private static final String INSERT_WHEEL_Q = "INSERT INTO car_wheels(size,wheel_type) VALUES(?,?)";
    private static final String UPDATE_WHEEL_Q = "UPDATE car_wheels SET size = ?, wheel_type = ? WHERE id = ?";
    private static final String DELETE_WHEEL_Q = "DELETE FROM car_wheels WHERE id = ?";


    @Override
    public List<Wheel> getWheels() {
        return jdbcTemplate.query(GET_WHEELS_Q, new BeanPropertyRowMapper<>(Wheel.class));
    }

    @Override
    public Wheel getWheelById(Integer id) {
        try {
            return jdbcTemplate.queryForObject(GET_WHEEL_BY_ID_Q, new BeanPropertyRowMapper<>(Wheel.class), id);
        } catch (EmptyResultDataAccessException e) {
            throw new WheelNotFoundException("No wheel with id: " + id + " was found");
        }
    }

    @Override
    public Integer insertWheel(Wheel wheel) {
        KeyHolder key = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(
                    INSERT_WHEEL_Q, new String[]{"id"});
            ps.setString(1, wheel.getSize());
            ps.setString(2, wheel.getWheelType());
            return ps;
        }, key);

        return key.getKey().intValue();
    }

    @Override
    public Boolean updateWheel(Wheel wheel) {
        var update = jdbcTemplate.update(UPDATE_WHEEL_Q, new Object[]{wheel.getSize(), wheel.getWheelType(), wheel.getId()});
        return update == -1 ? false : true;
    }

    @Override
    public Boolean deleteWheel(Integer id) {
        var delete = jdbcTemplate.update(DELETE_WHEEL_Q, new Object[]{id});
        return delete == -1 ? false : true;
    }
}
