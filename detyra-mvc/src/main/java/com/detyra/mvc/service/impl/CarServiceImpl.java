package com.detyra.mvc.service.impl;

import com.detyra.mvc.dto.Car;
import com.detyra.mvc.repository.CarDAO;
import com.detyra.mvc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDAO carDAO;

    @Override
    public List<Car> getCars() {
        return carDAO.getCars();
    }

    @Override
    public Car getCarById(Integer id) {
        return carDAO.getCarById(id);
    }

    @Override
    public Integer insertCar(Car car) {
        return carDAO.insertCar(car);
    }

    @Override
    public Boolean updateCar(Car car) {
        return carDAO.updateCar(car);
    }

    @Override
    public Boolean deleteCar(Integer id) {
        return carDAO.deleteCar(id);
    }
}
