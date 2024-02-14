package com.detyra.mvc.repository;

import com.detyra.mvc.dto.Car;

import java.util.List;

public interface CarDAO {
    List<Car> getCars();
    Car getCarById(Integer id);
    Integer insertCar(Car car);

    Boolean updateCar(Car car);
    Boolean deleteCar(Integer id);

}
