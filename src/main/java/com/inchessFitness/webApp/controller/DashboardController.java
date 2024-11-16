package com.inchessFitness.webApp.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
public class DashboardController {


    @RequestMapping("/displayDashboard")
    public String displayDashboard(){
        return "dashboard.html";
    }
}
