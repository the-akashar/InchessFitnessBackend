package com.inchessFitness.webApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {" ","/home","/index"})
    public String displayHome(){
        return "index.html";
    }

    @RequestMapping("/about-us")
    public String displayAbout(){
        return "about-us.html";
    }

    @RequestMapping("/class-details")
    public String displayClass(){
        return "class-details.html";
    }

    @RequestMapping("/services")
    public String displayService(){
        return "services.html";
    }

    @RequestMapping("/team")
    public String displayTeam(){
        return "team.html";
    }






}
