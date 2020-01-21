package com.example.restservice;

import org.springframework.boot.SpringApplication;
import java.util.Scanner;
import java.util.Collections;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.boot.ExitCodeGenerator;

@SpringBootApplication
public class RestServiceApplication {
    	
    public static void main(String[] args) {
        //Can run in http://localhost:8080/greeting
        SpringApplication.run(RestServiceApplication.class, args);
       
        // Can run in http://localhost:8083/greeting
        SpringApplication app = new SpringApplication(RestServiceApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);


    }
}
