package com.carelesscoders.contactmanagement.services;

import com.carelesscoders.contactmanagement.models.ContactDetails;
import com.carelesscoders.contactmanagement.repository.ContactDetailsRepository;
import com.carelesscoders.contactmanagement.utilities.ContactSpecification;
import com.carelesscoders.contactmanagement.utilities.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactDetailsService {

    @Autowired
    ContactDetailsRepository contactDetailsRepository;

    public List<ContactDetails> searchContacts(String firstName, String lastName, String email) {
        List<SearchCriteria> criteriaList = new ArrayList<>();
        if (firstName != null) {
            criteriaList.add(new SearchCriteria("firstName", ":", firstName));
        }
        if (lastName != null) {
            criteriaList.add(new SearchCriteria("lastName", ":", lastName));
        }
        if (email != null) {
            criteriaList.add(new SearchCriteria("email", ":", email));
        }
        Specification<ContactDetails> spec = null;
        for (SearchCriteria criteria : criteriaList) {
            if (spec == null) {
                spec = new ContactSpecification(criteria);
            } else {
                spec = spec.and(new ContactSpecification(criteria));
            }
        }

        return contactDetailsRepository.findAll(spec);
    }

    public ContactDetails findByFirstNameAndLastName(String firstName, String lastName){
        return contactDetailsRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    public void createNewContact(ContactDetails contactDetails) {
        contactDetailsRepository.save(contactDetails);
    }

    public void createContactsBatch(List<ContactDetails> contactDetailsList){
        contactDetailsRepository.saveAll(contactDetailsList);
    }

    public void updateContact(String firstName, String lastName, ContactDetails updatedContactDetails){
        ContactDetails contactDetails = findByFirstNameAndLastName(firstName,lastName);
        if(contactDetails!=null){
            contactDetails.setEmail(updatedContactDetails.getEmail());
            contactDetails.setFirstName(updatedContactDetails.getFirstName());
            contactDetails.setLastName(updatedContactDetails.getLastName());
            contactDetails.setMobileNo(updatedContactDetails.getMobileNo());
            contactDetailsRepository.save(contactDetails);
        }else {
            throw new RuntimeException();
        }
    }

    public void deleteByFirstNameAndLastName(String firstName, String lastName){
        contactDetailsRepository.deleteByFirstNameAndLastName(firstName,lastName);
    }

}
