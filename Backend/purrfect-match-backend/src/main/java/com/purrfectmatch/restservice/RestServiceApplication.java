package com.purrfectmatch.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;




@SpringBootApplication
public class RestServiceApplication {
        public static void main(String... args) {
                // Change port to run on here:
                ConfigurableApplicationContext app = SpringApplication.run(RestServiceApplication.class, args);
        }
}