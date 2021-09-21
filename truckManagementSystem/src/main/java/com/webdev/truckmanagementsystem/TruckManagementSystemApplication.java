package com.webdev.truckmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
public class TruckManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TruckManagementSystemApplication.class, args);
    }

}
