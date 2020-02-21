package com.purrfectmatch.restservice;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(ShelterAccountRepository shelterAccountRepository,
      SuccessStoryRepository successStoryRepository) {
    return args -> {
      log.info("Preloading " + successStoryRepository.save(new SuccessStory("Fuzzles", "Cute dog")));
      log.info("Preloading " + successStoryRepository.save(new SuccessStory("Phaedo", "Lovable dog")));
      log.info("Preloading " + shelterAccountRepository.save(new ShelterAccount("bob@google.com", "password", "hjhasjk",
          "Woods Humane society", "SLO", "Mill Street", "CA", 93405, "4083487777", "www.google.com")));
    };
  }
}

// shelter account
/*
 * email, String passwordHash, String passwordSalt, String shelterName, String
 * city, String street, String state, int zipCode, String phoneNumber, String
 * website
 */