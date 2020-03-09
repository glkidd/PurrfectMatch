package com.purrfectmatch.restservice;

import com.purrfectmatch.restservice.Breeds.Breed;
import com.purrfectmatch.restservice.Breeds.BreedRepository;
import com.purrfectmatch.restservice.RecentlyAdopted.RecentlyAdopted;
import com.purrfectmatch.restservice.RecentlyAdopted.RecentlyAdoptedRepository;
import com.purrfectmatch.restservice.ShelterAccounts.ShelterAccount;
import com.purrfectmatch.restservice.ShelterAccounts.ShelterAccountRepository;
import com.purrfectmatch.restservice.SuccessStories.SuccessStory;
import com.purrfectmatch.restservice.SuccessStories.SuccessStoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@Slf4j
class LoadDatabase {
        @Bean
        CommandLineRunner initDatabase(ShelterAccountRepository shelterAccountRepository,
                        SuccessStoryRepository successStoryRepository,
                        RecentlyAdoptedRepository recentlyAdoptedRepository, BreedRepository bRepo) {
                return args -> {
                        shelterAccountRepository.deleteAll();
                        successStoryRepository.deleteAll();
                        bRepo.deleteAll();
                        recentlyAdoptedRepository.deleteAll();
                        log.info("Preloading " + bRepo.save(new Breed("spaniel", Species.DOG)));
                        log.info("Preloading " + bRepo.save(new Breed("german shepherd", Species.DOG)));
                        log.info("Preloading " + bRepo.save(new Breed("dachshund", Species.DOG)));
                        log.info("Preloading " + bRepo.save(new Breed("saint bernard", Species.DOG)));
                        log.info("Preloading " + bRepo.save(new Breed("husky", Species.DOG)));
                        log.info("Preloading " + bRepo.save(new Breed("golden retriever", Species.DOG)));
                        log.info("Preloading " + bRepo.save(new Breed("pug", Species.DOG)));
                        log.info("Preloading " + bRepo.save(new Breed("french bulldog", Species.DOG)));
                        log.info("Preloading " + bRepo.save(new Breed("pitbull", Species.DOG)));
                        log.info("Preloading " + bRepo.save(new Breed("chihuahua", Species.DOG)));
                        log.info("Preloading " + bRepo.save(new Breed("great dane", Species.DOG)));
                        log.info("Preloading " + bRepo.save(new Breed("pomerian", Species.DOG)));
                        log.info("Preloading " + successStoryRepository
                                        .save(new SuccessStory("cutedog.png", "Fuzzles", LocalDate.of(1998, 3, 14), 1,
                                                        LocalDate.of(2019, 3, 24), Gender.FEMALE, "BYE")));
                        log.info("Preloading " + successStoryRepository
                                        .save(new SuccessStory("cutemaledog.png", "Phaedo", LocalDate.of(1998, 3, 24),
                                                        2, LocalDate.of(2019, 3, 24), Gender.MALE, "HIIII")));
                        log.info("Preloading " + shelterAccountRepository.save(new ShelterAccount("bob@google.com",
                                        "password", "hjhasjk", "Woods Humane society", "SLO", "Mill Street", "CA",
                                        93405, "4083487777", "www.google.com")));
                        log.info("Preloading " + recentlyAdoptedRepository.save(
                                        new RecentlyAdopted("barack.png", "barack obama", null, 4, null, Gender.MALE)));
                        int i = 0;
                        while (i < 25) {
                                log.info("Preloading "
                                                + recentlyAdoptedRepository.save(new RecentlyAdopted("barack.png",
                                                                "barack obama", null, 4, null, Gender.MALE)));
                                i++;
                        }
                        log.info("Preloading " + bRepo.save(new Breed("taxa", Species.DOG)));
                };
        }

}