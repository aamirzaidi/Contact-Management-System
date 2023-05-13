package com.carelesscoders.contactmanagement.utilities;

import com.carelesscoders.contactmanagement.models.ContactDetails;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ContactSpecification implements Specification<ContactDetails> {
    private final SearchCriteria criteria;

    public ContactSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<ContactDetails> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (criteria.getKey().equalsIgnoreCase("email")) {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }  else {
                return builder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
            }
        }
        return null;
    }
}