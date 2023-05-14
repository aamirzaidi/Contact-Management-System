package com.carelesscoders.contactmanagement.controllers;

import com.carelesscoders.contactmanagement.models.ContactDetails;
import com.carelesscoders.contactmanagement.services.ContactDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactDetailsController {

    @Autowired
    ContactDetailsService contactDetailsService;

    @Operation(description = "Search Contact Service. Search results can be filtered on basis of first name, last name, or email. Provide the parameters as query parameters to do the filtering. ")
    @GetMapping(value = "/search")
    public ResponseEntity<List<ContactDetails>> findContacts(@RequestParam(value = "firstName", required = false) String firstName,
                                             @RequestParam(value = "lastName",required = false) String lastName,
                                             @RequestParam(value = "email", required = false) String email){
        List<ContactDetails> contactDetailsList = contactDetailsService.searchContacts(firstName, lastName, email);
        if(contactDetailsList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contactDetailsList, HttpStatus.OK);
    }

    @Operation(description = "Add New Contact")
    @PostMapping("/create")
    public ResponseEntity<ContactDetails> createContact(@RequestBody ContactDetails contactDetails){
        ContactDetails contact = contactDetailsService.createNewContact(contactDetails);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    @Operation(description = "Add New Contacts In Batch")
    @PostMapping("/create/batch")
    public ResponseEntity<List<ContactDetails>> createContactsBatch(@RequestBody List<ContactDetails> contactDetailsList){
        List<ContactDetails> list = contactDetailsService.createContactsBatch(contactDetailsList);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @Operation(description = "Update Contact Based on First Name & Last Name")
    @PutMapping("/update")
    public ResponseEntity<ContactDetails> updateContact(@RequestParam String firstName, @RequestParam String lastName, @RequestBody ContactDetails contactDetails){
        ContactDetails contact = contactDetailsService.updateContact(firstName, lastName, contactDetails);
        if(contact == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(contact, HttpStatus.OK);
        }
    }

    @Operation(description = "Delete Contact based on First Name & Last Name")
    @Transactional
    @DeleteMapping("/delete")
    public ResponseEntity<ContactDetails> deleteContact(@RequestParam String firstName, @RequestParam String lastName){
        ContactDetails contactDetails = contactDetailsService.findByFirstNameAndLastName(firstName,lastName);
        if(contactDetails == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contactDetailsService.deleteByFirstNameAndLastName(firstName,lastName);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}