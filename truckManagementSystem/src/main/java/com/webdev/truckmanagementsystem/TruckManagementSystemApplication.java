package com.webdev.truckmanagementsystem;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
public class TruckManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TruckManagementSystemApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${application.name}") String appName,
                                 @Value("${application.description}") String description) {
        return new OpenAPI().components(new Components()).info(new Info().title(appName).description(description));
    }

}
