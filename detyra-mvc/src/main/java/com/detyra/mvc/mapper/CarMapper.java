package com.detyra.mvc.mapper;

import com.detyra.mvc.dto.Engine;
import com.detyra.mvc.dto.Car;
import com.detyra.mvc.dto.Wheel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setCarName(rs.getString("car_name"));
        car.setFromYear(rs.getInt("from_year"));
        car.setToYear(rs.getInt("to_year"));

        Wheel wheel = new Wheel();
        wheel.setId(rs.getInt("wheels_id"));
        wheel.setSize(rs.getString("size"));
        wheel.setWheelType(rs.getString("wheel_type"));

        car.setWheelsId(wheel);

        Engine engine = new Engine();
        engine.setId(rs.getInt("engine_id"));
        engine.setEnginePower(rs.getInt("engine_power"));
        engine.setEngineType(rs.getString("engine_type"));

        car.setEngineId(engine);
        return car;
    }
}
