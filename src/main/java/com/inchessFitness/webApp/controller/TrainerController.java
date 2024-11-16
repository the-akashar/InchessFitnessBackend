package com.inchessFitness.webApp.controller;


import com.inchessFitness.webApp.model.Trainers;
import com.inchessFitness.webApp.repository.TrainersRepository;
import com.inchessFitness.webApp.service.TrainersService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class TrainerController {



    @Autowired
    TrainersService trainersService;

    @Autowired
    TrainersRepository trainerRepository;




    @RequestMapping("/displayTrainers")
    public ModelAndView displayAddedTrainers(Model model){
        List<Trainers> trainersList = trainerRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("trainers.html");
        modelAndView.addObject("trainersList",trainersList);
        return modelAndView;
    }


    @RequestMapping("/addTrainers")
    public String addTrainers(Model model){
        model.addAttribute("trainer",new Trainers());
        return "register.html";
    }


    @RequestMapping(value = "/createTrainers" , method = RequestMethod.POST )
    public String createTrainers(@Valid @ModelAttribute("trainer")Trainers trainer , Errors errors){
        if(errors.hasErrors()){
            return "register.html";
        }

        boolean isSaved = trainersService.createNewTrainer(trainer);
        if (isSaved){
            return "redirect:/displayTrainers";
        } else {
            return "register.html";
        }
    }

    @RequestMapping("/deleteTrainers")
    public ModelAndView deleteContact(Model model , @RequestParam int id){
        Optional<Trainers> trainer = trainerRepository.findById(id);
        if (trainer.get().getTrainersid() > 0){
            trainerRepository.deleteById(id);
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/displayTrainers");
        return modelAndView;

    }



}
