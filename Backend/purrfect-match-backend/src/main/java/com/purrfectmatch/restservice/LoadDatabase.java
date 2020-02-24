package com.purrfectmatch.restservice;

import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {
        @Bean
        CommandLineRunner initDatabase(ShelterAccountRepository shelterAccountRepository,
                        SuccessStoryRepository successStoryRepository,
                        RecentlyAdoptedRepository recentlyAdoptedRepository, BreedRepository bRepo) {
                return args -> {
                        /*
                         * log.info("Preloading " + bRepo.save(new Breed("spaniel", Species.dog)));
                         * log.info("Preloading " + bRepo.save(new Breed("german shepherd",
                         * Species.dog))); log.info("Preloading " + bRepo.save(new Breed("dachshund",
                         * Species.dog))); log.info("Preloading " + bRepo.save(new
                         * Breed("saint bernard", Species.dog))); log.info("Preloading " +
                         * bRepo.save(new Breed("husky", Species.dog))); log.info("Preloading " +
                         * bRepo.save(new Breed("golden retriever", Species.dog)));
                         * log.info("Preloading " + bRepo.save(new Breed("pug", Species.dog)));
                         * log.info("Preloading " + bRepo.save(new Breed("french bulldog",
                         * Species.dog))); log.info("Preloading " + bRepo.save(new Breed("pitbull",
                         * Species.dog))); log.info("Preloading " + bRepo.save(new Breed("chihuahua",
                         * Species.dog))); log.info("Preloading " + bRepo.save(new Breed("great dane",
                         * Species.dog))); log.info("Preloading " + bRepo.save(new Breed("pomerian",
                         * Species.dog)));
                         */
                        log.info("Preloading " + successStoryRepository.save(new SuccessStory("cutedog.png", "Fuzzles",
                                        new Date(1998, 3, 14), 1, new Date(2019, 3, 24), Gender.female, "BYE")));
                        log.info("Preloading " + successStoryRepository
                                        .save(new SuccessStory("cutemaledog.png", "Phaedo", new Date(1998, 3, 24), 2,
                                                        new Date(2019, 3, 24), Gender.male, "HIIII")));
                        log.info("Preloading " + shelterAccountRepository.save(new ShelterAccount("bob@google.com",
                                        "password", "hjhasjk", "Woods Humane society", "SLO", "Mill Street", "CA",
                                        93405, "4083487777", "www.google.com")));
                        log.info("Preloading " + recentlyAdoptedRepository.save(
                                        new RecentlyAdopted("barack.png", "barack obama", null, 4, null, Gender.male)));
                        int i = 0;
                        while (i < 25) {
                                log.info("Preloading "
                                                + recentlyAdoptedRepository.save(new RecentlyAdopted("barack.png",
                                                                "barack obama", null, 4, null, Gender.male)));
                                i++;
                        }
                };
        }

}

// public Breed(String breedName, Species species) {
// RecentlyAdopted(String image, String name, Date birthday, int breed, Date
// dateAdopted, Gender gender) {
