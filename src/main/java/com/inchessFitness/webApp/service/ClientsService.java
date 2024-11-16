package com.inchessFitness.webApp.service;


import com.inchessFitness.webApp.model.Clients;
import com.inchessFitness.webApp.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {

    @Autowired
   private ClientsRepository clientsRepository;



    public boolean createNewClienst(Clients clients){
        boolean isSaved = false;
        Clients  saveClients = clientsRepository.save(clients);
        if (null!=clients && clients.getClientsId() >0 ){
            isSaved = true;
        }
        return isSaved;
    }

    public List<Clients> listAll() {
        return clientsRepository.findAll(Sort.by("email").ascending());
    }
}
