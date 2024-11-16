package com.inchessFitness.webApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmrController {
    @GetMapping("/bmr")
    public String displayBmr(){
        return "bmrCalculator";
    }

    @PostMapping("/calculateBmr")
    public String calculateBMR(@RequestParam("height") double height,
                               @RequestParam("weight") double weight,
                               @RequestParam("age") double age,
                               @RequestParam("activityFactor") double af,
                               @RequestParam("sex") String sex,
                               Model model) {

        double bmr = 0;

        if (sex.equals("M")) {
            bmr = (88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age))*af;
        } else if (sex.equals("F")) {
            bmr = (447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age))*af;
        }

        model.addAttribute("bmr", bmr);

        return "bmrCalculator";
    }


}
