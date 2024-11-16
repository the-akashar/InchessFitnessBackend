package com.inchessFitness.webApp.controller;

import com.inchessFitness.webApp.model.Clients;
import com.inchessFitness.webApp.model.Contact;
import com.inchessFitness.webApp.repository.ContactRepository;
import com.inchessFitness.webApp.service.ClientsService;
import com.inchessFitness.webApp.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Slf4j
@Controller
public class ContactController {


    @Autowired
    ContactService contactService;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ClientsService clientsService;
    @RequestMapping("/contact")
    public String displayContact(Model model ){
        model.addAttribute("contact",new Contact());
        return "contact.html";
    }


    @RequestMapping(value="/saveMsg",method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact , Error error){
        contactService.saveMessagedetails(contact);
        return "redirect:/contact";

    }

    @RequestMapping(value = {"/displayEnquiry"})
    public ModelAndView displayEnquiry(Model model){
        List<Contact> contactMsg = contactService.findMsgsWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("enquiry.html");
        modelAndView.addObject("contactMsg",contactMsg);
        return modelAndView;
    }

    @RequestMapping("/deleteEnquiry")
    public ModelAndView deleteContact(Model model , @RequestParam int id){
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.get().getContactId() > 0){
            contactRepository.deleteById(id);
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/displayEnquiry");
        return modelAndView;

    }

    @RequestMapping("/addClient")
    public ModelAndView addClient(Model model , @RequestParam int id){
        Optional<Contact> contact = contactRepository.findById(id);
        Clients clients = new Clients();
        clients.setName(contact.get().getName());
        clients.setEmail(contact.get().getEmail());
        clients.setGoal(contact.get().getGoal());
        clients.setMobileNumber(contact.get().getMobileNum());
        ModelAndView modelAndView = new ModelAndView("populatedClientsForm.html");
        modelAndView.addObject("clients", clients);
        contactRepository.deleteById(id);
        return modelAndView;
    }

    @RequestMapping(value = "/createPopulatedClients" , method = {RequestMethod.POST})
    public String createClients(@Valid @ModelAttribute("clients") Clients clients , Errors errors){
        if(errors.hasErrors()){
            return "populatedClientsForm.html";
        }

        boolean isSaved = clientsService.createNewClienst(clients);
        if (isSaved){
            return "redirect:/displayClients";
        } else {
            return "populatedClientsForm.html";
        }
    }

}
