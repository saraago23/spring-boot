package com.detyra.mvc.controller;

import com.detyra.mvc.dto.Wheel;
import com.detyra.mvc.service.WheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/wheels")
public class WheelController {
    @Autowired
    private WheelService wheelService;

    @GetMapping
    public String getWheelsView(Model model) {
        List<Wheel> wheels = wheelService.getWheels();
        model.addAttribute("wheels", wheels);
        return "plain/wheels-view-plain";
    }

    @GetMapping("/{wheelId}")
    public String getWheelById(@PathVariable(name = "wheelId") Integer id, Model model) {
        var wheel = wheelService.getWheelById(id);
        model.addAttribute("wheel", wheel);
        return "plain/wheels-view-form-plain";
    }

    @GetMapping("/edit")
    public String getWheelsForm(Model model, @RequestParam(name = "wheel", required = false) Integer wheelId) {
        System.err.println("wheelId" + wheelId);
        if (wheelId == null) {
            var wheel = new Wheel();
            model.addAttribute("wheel", wheel);
        } else {
            var wheel = wheelService.getWheelById(wheelId);
            model.addAttribute("wheel", wheel);
        }

        return "plain/wheels-view-form-plain";
    }

    @PostMapping
    public String insertEngine(@ModelAttribute("wheel") Wheel wheel, BindingResult result) {
       /* if(result.hasErrors()){
            System.err.println("hass errors");
            return "plain/car-view-form-plain";
        }*/
        if (wheel.getId() == null)
            wheelService.insertWheel(wheel);
        else
           wheelService.updateWheel(wheel);
        return "redirect:/wheels";
    }


    @GetMapping("/{wheelId}/delete")
    public String deleteEngine(@PathVariable Integer wheelId) {
       wheelService.deleteWheel(wheelId);
        return "redirect:/wheels";
    }
}
