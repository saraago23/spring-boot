package com.detyra.mvc.repository.impl;

import com.detyra.mvc.dto.Engine;
import com.detyra.mvc.exception.CarNotFoundException;
import com.detyra.mvc.exception.EngineNotFoundException;
import com.detyra.mvc.repository.EngineDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EngineDAOImpl implements EngineDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ENGINES_Q = "SELECT * FROM car_engines";
    private static final String GET_ENGINE_BY_ID_Q = "SELECT * FROM car_engines WHERE id=?";
    private static final String INSERT_ENGINE_Q = "INSERT INTO car_engines(engine_power,engine_type) VALUES(?,?)";
    private static final String UPDATE_ENGINE_Q = "UPDATE car_engines SET engine_power = ?, engine_type = ? WHERE id = ?";
    private static final String DELETE_ENGINE_Q = "DELETE FROM car_engines WHERE id = ?";

    @Override
    public List<Engine> getEngines() {
        return jdbcTemplate.query(GET_ENGINES_Q,new BeanPropertyRowMapper<>(Engine.class));
    }

    @Override
    public Engine getEngineById(Integer id) {
        try {
            return jdbcTemplate.queryForObject(GET_ENGINE_BY_ID_Q, new BeanPropertyRowMapper<>(Engine.class), id);
        }catch (EmptyResultDataAccessException e){
            throw new EngineNotFoundException("No engine with id: " + id + " was found");
        }
    }

    @Override
    public Integer insertEngine(Engine engine) {
        KeyHolder key = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(
                   INSERT_ENGINE_Q, new String[]{"id"});
            ps.setInt(1, engine.getEnginePower());
            ps.setString(2, engine.getEngineType());
            return ps;
        }, key);

        return key.getKey().intValue();
    }

    @Override
    public Boolean updateEngine(Engine engine) {
        var update = jdbcTemplate.update(UPDATE_ENGINE_Q, new Object[]{engine.getEnginePower(),engine.getEngineType(),engine.getId()});
        return update == -1 ? false : true;
    }

    @Override
    public Boolean deleteEngine(Integer id) {
        var delete = jdbcTemplate.update(DELETE_ENGINE_Q, new Object[]{id});
        return delete == -1 ? false : true;
    }
}
