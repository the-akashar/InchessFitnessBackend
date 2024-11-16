package com.inchessFitness.webApp.service;


import com.inchessFitness.webApp.constants.InchessFitnessConstants;
import com.inchessFitness.webApp.model.Contact;
import com.inchessFitness.webApp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContactService {


    @Autowired
    private ContactRepository contactRepository;


    public boolean saveMessagedetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(InchessFitnessConstants.OPEN);
        contact.setCreatedBy(InchessFitnessConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        Contact saveContact = contactRepository.save(contact);
        if (null != saveContact && saveContact.getContactId()>0){
            isSaved = true;
        }
        return isSaved;
    }


    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsg = contactRepository.findByStatus(InchessFitnessConstants.OPEN);
        return contactMsg;
    }

}
