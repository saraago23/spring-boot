package com.detyra.mvc.controller;

import com.detyra.mvc.dto.Engine;
import com.detyra.mvc.dto.Car;
import com.detyra.mvc.dto.Wheel;
import com.detyra.mvc.service.CarService;
import com.detyra.mvc.service.EngineService;
import com.detyra.mvc.service.WheelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private EngineService engineService;

    @Autowired
    private WheelService wheelService;

    @GetMapping
    public String getCarsView(Model model) {
        List<Car> cars = carService.getCars();
        model.addAttribute("cars", cars);
        return "plain/cars-view-plain";
    }

    @GetMapping("/{carId}")
    public String getCarById(@PathVariable(name = "carId") Integer carId, Model model) {
        var car = carService.getCarById(carId);
        model.addAttribute("car", car);
        return "plain/cars-view-form-plain";
    }

    @GetMapping("/edit")
    public String getCarsForm(Model model, @RequestParam(name = "car", required = false) Integer carId) {
        System.err.println("carId" + carId);
        if (carId == null) {
            model.addAttribute("car", new Car());
        } else {
            var car = carService.getCarById(carId);
            model.addAttribute("car", car);
        }

        loadDropDowns(model);

        return "plain/cars-view-form-plain";
    }

    @PostMapping
    public String insertCar(Model model, @ModelAttribute("car") @Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            loadDropDowns(model);
            System.err.println("hass errors");
            return "plain/cars-view-form-plain";
        }
        if (car.getId() == null)
            carService.insertCar(car);
        else
            carService.updateCar(car);
        return "redirect:/cars";
    }

    private void loadDropDowns(Model model) {
        List<Engine> allEngines = engineService.getEngines();
        Map<Integer, String> engineTypeMap = new HashMap<>();
        allEngines.forEach(e -> engineTypeMap.put(e.getId(), e.getEngineType()));
        model.addAttribute("engineTypeMap", engineTypeMap);

        List<Wheel> allWheel = wheelService.getWheels();
        Map<Integer, String> wheelTypeMap = new HashMap<>();
        allWheel.forEach(w -> wheelTypeMap.put(w.getId(), w.getWheelType() +" "+w.getSize()));
        model.addAttribute("wheelTypeMap", wheelTypeMap);
    }


    @GetMapping("/{carId}/delete")
    public String deleteCar(@PathVariable Integer carId) {
        carService.deleteCar(carId);
        return "redirect:/cars";
    }
}
