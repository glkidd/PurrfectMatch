package com.purrfectmatch.restservice;

import lombok.extern.slf4j.Slf4j;

import com.purrfectmatch.restservice.Employees.Employee;
import com.purrfectmatch.restservice.Employees.EmployeeRepository;
import com.purrfectmatch.restservice.SuccessStories.SuccessStory;
import com.purrfectmatch.restservice.SuccessStories.SuccessStoryRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository employeeRepository, SuccessStoryRepository successStoryRepository) {
    //, ContactPageRepository contactPageRepository
    return args -> {
      log.info("Preloading " + successStoryRepository.save(new SuccessStory("Fuzzles", "4")));
      log.info("Preloading " + successStoryRepository.save(new SuccessStory("Phaedo", "1")));
      log.info("Preloading " + employeeRepository.save(new Employee("Tim", "Go", "Woods Humane society")));
      log.info("Preloading " + employeeRepository.save(new Employee("Alex", "Blah", "PET Lovers")));
      //log.info("Preloading " + contactPageRepository.save(new ContactPage("Tim", "Go", "Woods Humane society")));
      //log.info("Preloading " + contactPageRepository.save(new ContactPage("Alex", "Blah", "PET Lovers")));
    };
  }
}