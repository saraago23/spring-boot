package com.detyra.mvc.service;

import com.detyra.mvc.dto.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    Car getCarById(Integer id);
    Integer insertCar(Car car);
   // Boolean insertTheCar(Car car);
    Boolean updateCar(Car car);
    Boolean deleteCar(Integer id);
}
