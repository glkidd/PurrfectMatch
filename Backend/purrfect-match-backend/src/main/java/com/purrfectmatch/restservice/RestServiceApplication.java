package com.purrfectmatch.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;

@SpringBootApplication
public class RestServiceApplication {
        public static void main(String... args) {
                // Change port to run on here:
                SpringApplication app = new SpringApplication(RestServiceApplication.class);
                app.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
                app.run(args);
        }
}