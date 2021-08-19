package com.webdev.solid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
public class SolidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolidApplication.class, args);
    }

}
