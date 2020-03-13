package com.purrfectmatch.restservice;

import com.purrfectmatch.restservice.Breeds.Breed;
import com.purrfectmatch.restservice.Breeds.BreedRepository;
import com.purrfectmatch.restservice.RecentlyAdopted.RecentlyAdopted;
import com.purrfectmatch.restservice.RecentlyAdopted.RecentlyAdoptedRepository;
import com.purrfectmatch.restservice.ShelterAccounts.ShelterAccount;
import com.purrfectmatch.restservice.ShelterAccounts.ShelterAccountRepository;
import com.purrfectmatch.restservice.ShelterAccounts.ShelterAuth;
import com.purrfectmatch.restservice.SuccessStories.SuccessStory;
import com.purrfectmatch.restservice.SuccessStories.SuccessStoryRepository;
import com.purrfectmatch.restservice.Cats.CatRepository;
import com.purrfectmatch.restservice.Cats.Cat;
import com.purrfectmatch.restservice.FurLength;

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
                        RecentlyAdoptedRepository recentlyAdoptedRepository, BreedRepository bRepo, CatRepository catRepo) {
                return args -> {
                        catRepo.deleteAll();
                        shelterAccountRepository.deleteAll();
                        successStoryRepository.deleteAll();
                        recentlyAdoptedRepository.deleteAll();
                        bRepo.deleteAll();
                        
                        
                        Breed tempBreed = new Breed("meow", Species.CAT);
                        log.info("Preloading " + bRepo.save(tempBreed));
                        
                        ShelterAccount tempAcc = ShelterAuth.createAccount("email@gmail.com",
                                "password".toCharArray(), "Test Shelter", "San Luis Obispo", "1 Grand Ave", "CA",
                                93410, "5555555555", "example.com");
                        log.info("Preloading " + shelterAccountRepository.save(tempAcc));

                        Cat tempCat = new Cat("cat.png", 
                                "NotAtRisk", 
                                LocalDate.of(1999, 1, 1), 
                                tempBreed.getId(), 
                                Gender.FEMALE, 
                                FurLength.SHORT, 
                                "bio", 
                                LocalDate.of(2020, 1, 1), 
                                null, 
                                true, 
                                tempAcc.getId());
                        log.info("Preloading" + catRepo.save(tempCat));

                        log.info("Preloading" + catRepo.save(new Cat("cat.png", 
                                "AtRisk", 
                                LocalDate.of(1999, 1, 1), 
                                tempBreed.getId(), 
                                Gender.FEMALE, 
                                FurLength.SHORT, 
                                "bio", 
                                LocalDate.of(2020, 1, 1), 
                                LocalDate.of(2022, 1, 1), 
                                true, 
                                tempAcc.getId())));
                        log.info("Preloading" + catRepo.save(new Cat("cat.png", 
                                "AtRiskMale", 
                                LocalDate.of(1999, 1, 1), 
                                tempBreed.getId(), 
                                Gender.MALE, 
                                FurLength.SHORT, 
                                "bio", 
                                LocalDate.of(2020, 1, 1), 
                                LocalDate.of(2022, 1, 1), 
                                true, 
                                tempAcc.getId())));                    
                        
                        log.info("Preloading " + successStoryRepository
                                        .save(new SuccessStory("cutedog.png", "Fuzzles", LocalDate.of(1998, 3, 14), tempBreed.getId().intValue(),
                                                        LocalDate.of(2019, 3, 24), Gender.FEMALE, "BYE")));
                        log.info("Preloading " + successStoryRepository
                                        .save(new SuccessStory("cutemaledog.png", "Phaedo", LocalDate.of(1998, 3, 24),
                                                        tempBreed.getId().intValue(), LocalDate.of(2019, 3, 24), Gender.MALE, "HIIII")));

                        log.info("Preloading " + recentlyAdoptedRepository.save(
                                        new RecentlyAdopted("barack.png", "barack obama", null, tempBreed.getId().intValue(), null, Gender.MALE)));
                        int i = 0;
                        while (i < 25) {
                                log.info("Preloading "
                                                + recentlyAdoptedRepository.save(new RecentlyAdopted("barack.png",
                                                                "barack obama", null, tempBreed.getId().intValue(), null, Gender.MALE)));
                                i++;
                        }
                };
        }

}