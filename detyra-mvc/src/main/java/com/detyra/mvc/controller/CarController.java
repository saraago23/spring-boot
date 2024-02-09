package com.detyra.mvc.controller;

import com.detyra.mvc.dto.Engine;
import com.detyra.mvc.dto.Car;
import com.detyra.mvc.dto.Wheel;
import com.detyra.mvc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public String getCarsView(Model model) {
        List<Car> cars=carService.getCars();
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
    public String getCarsForm(Model model, @RequestParam(name = "car",required = false) Integer carId){
        System.err.println("carId"+carId);
        if (carId==null){
            var car = new Car();
            car.setWheelsId(new Wheel());
            car.setEngineId(new Engine());
            model.addAttribute("car",car);
        }else {
            var car = carService.getCarById(carId);
            model.addAttribute("car",car);
        }
        Map<String,Integer> engineTypeMap = Map
                .of("Diesel",4,"Gas",5,"Gasoline",6);
        model.addAttribute("engineTypeMap",engineTypeMap);

        Map<String,Integer> wheelTypeMap = Map

                .of("Steel",1,"Allow",3);
        model.addAttribute("wheelTypeMap",wheelTypeMap);

        return "plain/cars-view-form-plain";
    }
    @PostMapping
    public String insertCar(@ModelAttribute("car") Car car, BindingResult result){
       /* if(result.hasErrors()){
            System.err.println("hass errors");
            return "plain/car-view-form-plain";
        }*/
        if(car.getId()==null)
            carService.insertCar(car);
        else
           carService.updateCar(car);
        return "redirect:/cars";
    }


    @GetMapping("/{carId}/delete")
    public String deleteCar(@PathVariable Integer carId){
        carService.deleteCar(carId);
        return "redirect:/cars";
    }
}
