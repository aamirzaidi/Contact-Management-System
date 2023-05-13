package com.carelesscoders.contactmanagement.repository;

import com.carelesscoders.contactmanagement.models.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails, String>, JpaSpecificationExecutor<ContactDetails> {
    ContactDetails findByFirstNameAndLastName(String firstName, String lastName);

    void deleteByFirstNameAndLastName(String firstName, String lastName);
}


