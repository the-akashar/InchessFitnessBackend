package com.inchessFitness.webApp.controller;


import com.inchessFitness.webApp.model.Clients;
import com.inchessFitness.webApp.pdf.ClientsPdfExporter;
import com.inchessFitness.webApp.pdf.InvoiceGenerator;
import com.inchessFitness.webApp.repository.ClientsRepository;
import com.inchessFitness.webApp.service.ClientsService;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ClientController {


    @Autowired
    private ClientsService clientsService;

    @Autowired
    private ClientsRepository clientsRepository;


    @RequestMapping("/displayClients")
    public ModelAndView displayClients(Model model){
        List<Clients> clientsList = clientsRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("clients.html");
        modelAndView.addObject("clientsList",clientsList);
        return modelAndView;
    }

    @RequestMapping("/addClients")
    public String addTrainers(Model model){
        model.addAttribute("clients",new Clients());
        return "clientsForm.html";
    }

    @RequestMapping(value = "/createClients" , method = {RequestMethod.POST})
    public String createClients(@Valid @ModelAttribute("clients") Clients clients , Errors errors){
        if(errors.hasErrors()){
            return "clientsForm.html";
        }

        boolean isSaved = clientsService.createNewClienst(clients);
        if (isSaved){
            return "redirect:/displayClients";
        } else {
            return "clientsForm.html";
        }
    }

    @RequestMapping("/deleteClients")
    public ModelAndView deleteContact(Model model , @RequestParam int id){
        Optional<Clients> contact = clientsRepository.findById(id);
        if (contact.get().getClientsId() > 0){
            clientsRepository.deleteById(id);
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/displayClients");
        return modelAndView;

    }

    @GetMapping("/generatePdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=InchessFitnessInvoice" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Clients> listClients = clientsService.listAll();

        ClientsPdfExporter exporter = new ClientsPdfExporter(listClients);
        exporter.export(response);



    }



    @ResponseBody
    public ResponseEntity<Resource> generateInvoice() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        String fileName = "invoice.pdf";
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            invoiceGenerator.generateInvoice(String.valueOf(outputStream));
            byte[] invoiceBytes = outputStream.toByteArray();

            ByteArrayResource resource = new ByteArrayResource(invoiceBytes);

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                    .body(resource);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ByteArrayResource(new byte[0]));
        }
    }




}
