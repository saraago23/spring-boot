package com.detyra.mvc.repository.impl;

import com.detyra.mvc.dto.Car;
import com.detyra.mvc.mapper.CarMapper;
import com.detyra.mvc.repository.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_CARS_Q = "SELECT * FROM cars c JOIN car_wheels cw ON c.wheels_id= cw.id JOIN car_engines ce ON c.engine_id=ce.id";
    private static final String GET_CAR_BY_ID_Q = "SELECT * FROM cars c JOIN car_wheels cw ON c.wheels_id= cw.id JOIN car_engines ce ON c.engine_id=ce.id WHERE c.id=?";
    private static final String INSERT_CAR_WITH_WHEEL_Q = "INSERT INTO cars(car_name,from_year,to_year,wheels_id) VALUES(?,?,?,?)";
    private static final String INSERT_CAR_Q = "INSERT INTO cars(car_name,from_year,to_year) VALUES(?,?,?)";
    private static final String UPDATE_CAR_Q = "UPDATE cars SET car_name = ?, from_year = ?, to_year = ?, wheels_id = ?,engine_id=? WHERE id = ?";
    private static final String DELETE_CAR_Q = "DELETE FROM cars WHERE id = ?";
    public static String INSERT_CARS_WHEEL_ID_Q = "INSERT INTO car_wheels(id) values(?)";
    public static String INSERT_CARS_ENGINE_ID_Q = "INSERT INTO car_engines(id) values(?)";

    @Override
    public List<Car> getCars() {
        return jdbcTemplate.query(GET_CARS_Q,new CarMapper());
    }

    @Override
    public Car getCarById(Integer id) {
        return jdbcTemplate.queryForObject(GET_CAR_BY_ID_Q, new CarMapper(), id);
    }

    @Override
    public Integer insertCar(Car car) {
        KeyHolder key = new GeneratedKeyHolder();
        KeyHolder wheelsKey = new GeneratedKeyHolder();
        KeyHolder engineKey = new GeneratedKeyHolder();
        if (car.getWheelsId()!=null){
            jdbcTemplate.update(con -> {
                var ps = con.prepareStatement(INSERT_CARS_WHEEL_ID_Q,new String[]{"id"});
                ps.setInt(1,car.getWheelsId().getId());
                return ps;
            },wheelsKey);
        }
        if (car.getEngineId()!=null){
            jdbcTemplate.update(con -> {
                var ps = con.prepareStatement(INSERT_CARS_ENGINE_ID_Q,new String[]{"id"});
                ps.setInt(1,car.getEngineId().getId());
                return ps;
            },engineKey);
        }

        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(
                    car.getWheelsId().getId()!=null?INSERT_CAR_WITH_WHEEL_Q:INSERT_CAR_Q,
                    new String[]{"id"});
            ps.setString(1, car.getCarName());
            ps.setInt(2, car.getFromYear());
            ps.setInt(3, car.getToYear());
            ps.setInt(4, car.getWheelsId().getId());
            ps.setInt(5, car.getEngineId().getId());

            return ps;
        }, key);

        return key.getKey().intValue();
    }

    @Override
    public Boolean updateCar(Car car) {
        var update = jdbcTemplate.update(UPDATE_CAR_Q, new Object[]{car.getCarName(),car.getFromYear(),car.getToYear(),car.getWheelsId().getId(),car.getEngineId().getId(),car.getId()});
        return update == -1 ? false : true;
    }

    @Override
    public Boolean deleteCar(Integer id) {
        var delete = jdbcTemplate.update(DELETE_CAR_Q, new Object[]{id});
        return delete == -1 ? false : true;
    }
}
