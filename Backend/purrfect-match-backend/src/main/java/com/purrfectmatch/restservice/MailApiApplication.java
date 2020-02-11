package com.purrfectmatch.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

//https://stackoverflow.com/questions/36387265/disable-all-database-related-auto-configuration-in-spring-boot
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MailApiApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MailApiApplication.class, args);
	}
}
 