package com.carelesscoders.contactmanagement.controllers;

import com.carelesscoders.contactmanagement.models.ContactDetails;
import com.carelesscoders.contactmanagement.services.ContactDetailsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactDetailsController {

    @Autowired
    ContactDetailsService contactDetailsService;

    @GetMapping(value = "/search")
    public List<ContactDetails> findContacts(@RequestParam(value = "firstName", required = false) String firstName,
                                             @RequestParam(value = "lastName",required = false) String lastName,
                                             @RequestParam(value = "email", required = false) String email){
        return contactDetailsService.searchContacts(firstName, lastName, email);
    }

    @PostMapping("/create")
    public void createContact(@RequestBody ContactDetails contactDetails){
        contactDetailsService.createNewContact(contactDetails);
    }

    @PostMapping("/create/batch")
    public void createContactsBatch(@RequestBody List<ContactDetails> contactDetailsList){
        contactDetailsService.createContactsBatch(contactDetailsList);
    }

    @PutMapping("/update")
    public void updateContact(@RequestParam String firstName, @RequestParam String lastName, @RequestBody ContactDetails contactDetails){
        contactDetailsService.updateContact(firstName, lastName, contactDetails);
    }

    @Transactional
    @DeleteMapping("/delete")
    public void deleteContact(@RequestParam String firstName, @RequestParam String lastName){
        contactDetailsService.deleteByFirstNameAndLastName(firstName,lastName);
    }


}