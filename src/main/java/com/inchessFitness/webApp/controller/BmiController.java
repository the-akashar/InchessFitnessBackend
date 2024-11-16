package com.inchessFitness.webApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {
    @GetMapping("/bmi")
    public String showBMIForm() {
        return "bmi-calculator";
    }

    @PostMapping("/calculateBmi")
    public String calculateBMI(@RequestParam("height") double height, @RequestParam("weight") double weight, Model model) {
        double bmi = weight / ((height / 100) * (height / 100));
        model.addAttribute("bmi", bmi);
        return "bmi-calculator";
    }
}
