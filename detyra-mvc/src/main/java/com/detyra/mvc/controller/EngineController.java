package com.detyra.mvc.controller;


import com.detyra.mvc.dto.Engine;
import com.detyra.mvc.service.EngineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/engines")
public class EngineController {
    @Autowired
    private EngineService engineService;

    @GetMapping
    public String getEnginesView(Model model) {
        List<Engine> engines = engineService.getEngines();
        model.addAttribute("engines", engines);
        return "plain/engine-view-plain";
    }

    @GetMapping("/{engineId}")
    public String getEngineById(@PathVariable(name = "engineId") Integer id, Model model) {
        var engine = engineService.getEngineById(id);
        model.addAttribute("engine", engine);
        return "plain/engine-view-form-plain";
    }

    @GetMapping("/edit")
    public String getEnginesForm(Model model, @RequestParam(name = "engine", required = false) Integer engineId) {
        System.err.println("engineId" + engineId);
        if (engineId == null) {
            var engine = new Engine();
            model.addAttribute("engine", engine);
        } else {
            var engine = engineService.getEngineById(engineId);
            model.addAttribute("engine", engine);
        }

        return "plain/engine-view-form-plain";
    }

    @PostMapping
    public String insertEngine(@ModelAttribute("engine") @Valid Engine engine, BindingResult result) {
        if(result.hasErrors()){
            System.err.println("hass errors");
            return "plain/engine-view-form-plain";
        }
        if (engine.getId() == null)
            engineService.insertEngine(engine);
        else
            engineService.updateEngine(engine);
        return "redirect:/engines";
    }


    @GetMapping("/{engineId}/delete")
    public String deleteEngine(@PathVariable Integer engineId) {
        engineService.deleteEngine(engineId);
        return "redirect:/engines";
    }
}
