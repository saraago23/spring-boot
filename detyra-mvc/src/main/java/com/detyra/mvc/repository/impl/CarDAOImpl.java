package com.detyra.mvc.repository.impl;

import com.detyra.mvc.dto.Car;
import com.detyra.mvc.exception.CarNotFoundException;
import com.detyra.mvc.mapper.CarMapper;
import com.detyra.mvc.repository.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    private static final String INSERT_CAR_Q = "INSERT INTO cars(car_name,from_year,to_year,wheels_id,engine_id) VALUES(?,?,?,?,?)";
    private static final String UPDATE_CAR_Q = "UPDATE cars SET car_name = ?, from_year = ?, to_year = ?, wheels_id = ?,engine_id=? WHERE id = ?";
    private static final String DELETE_CAR_Q = "DELETE FROM cars WHERE id = ?";

    @Override
    public List<Car> getCars() {
        return jdbcTemplate.query(GET_CARS_Q, new CarMapper());
    }

    @Override
    public Car getCarById(Integer id) {
        try {
            return jdbcTemplate.queryForObject(GET_CAR_BY_ID_Q, new CarMapper(), id);
        }catch (EmptyResultDataAccessException e){
            throw new CarNotFoundException("No car with id: " + id + " was found");
        }
    }

    @Override
    public Integer insertCar(Car car) {

        jdbcTemplate.update(INSERT_CAR_Q, car.getCarName(),car.getFromYear(),car.getToYear(),car.getWheelsId().getId(),car.getEngineId().getId());
        return 1;
    }

    @Override
    public Boolean updateCar(Car car) {
        var update = jdbcTemplate.update(UPDATE_CAR_Q, new Object[]{car.getCarName(), car.getFromYear(), car.getToYear(), car.getWheelsId().getId(), car.getEngineId().getId(), car.getId()});
        return update == -1 ? false : true;
    }

    @Override
    public Boolean deleteCar(Integer id) {
        var delete = jdbcTemplate.update(DELETE_CAR_Q, new Object[]{id});
        return delete == -1 ? false : true;
    }
}
