package com.carelesscoders.contactmanagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class ApiDocumentConfiguration {

    String description = "The contact management system is a tool that allows you to organize and keep track of your contacts. With this system, you can create, update, delete, and search for contacts. The system provides basic authentication security to ensure that only authorized users can access and modify the contacts.";
    @Bean
    public OpenAPI baseOpenAPI(){
        return new OpenAPI().info(new Info().title("Contact Management API Documentation").version("1.0.0").description(description));
    }
}
