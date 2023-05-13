package com.carelesscoders.contactmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.carelesscoders.contactmanagement"})
@EnableJpaRepositories({"com.carelesscoders.contactmanagement"})
@EntityScan(basePackages = {"com.carelesscoders.contactmanagement"}) // scan JPA entities
@SpringBootApplication
public class ContactManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactManagementApplication.class, args);
	}

}
