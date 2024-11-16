package com.inchessFitness.webApp.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class RevenueController {

    @RequestMapping("/displayRevenue")
    private String displayRevenue(){
        return "profit.html";
    }
}
