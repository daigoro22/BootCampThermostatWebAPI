package com.example.demo.controllers;

import com.example.demo.services.ThermoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/temperature")
public class FrontEndController {
    private ThermoService thermoService;
    @Autowired
    public FrontEndController(ThermoService thermoService){
        this.thermoService=thermoService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("allThermoInfos",thermoService.getAllThermoInfos());
        return "list";
    }
}
