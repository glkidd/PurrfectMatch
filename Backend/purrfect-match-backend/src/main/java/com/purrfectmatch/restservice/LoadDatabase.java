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
                        
                        
                        Breed tempBreed = new Breed("American Shorthair", Species.CAT);
                        log.info("Preloading " + bRepo.save(tempBreed));
                        
                        Breed tempBreed2 = new Breed("Siamese I guess?", Species.CAT);
                        log.info("Preloading " + bRepo.save(tempBreed2));
                        
                        ShelterAccount tempAcc = ShelterAuth.createAccount("email@gmail.com",
                                "password".toCharArray(), "Test Shelter", "San Luis Obispo", "1 Grand Ave", "CA",
                                93410, "5555555555", "example.com");
                        log.info("Preloading " + shelterAccountRepository.save(tempAcc));
                        
                        log.info("Preloading" + catRepo.save(new Cat(
                                "https://www.thesprucepets.com/thmb/mnQh4QB3JmRmck_Ky3Pzo66Jp24=/3744x3744/smart/filters:no_upscale()/bombay-cat-black-cat-584192512-5808f21c3df78c2c730fe3c1.jpg", 
                                "Ollie", 
                                LocalDate.of(2015, 1, 1), 
                                tempBreed2.getId(), 
                                Gender.MALE, 
                                FurLength.LONG, 
                                "insert bio", 
                                LocalDate.of(2020, 1, 1), 
                                LocalDate.of(2022, 1, 2), 
                                true, 
                                tempAcc.getId())));
                        log.info("Preloading" + catRepo.save(new Cat(
                                "https://felineengineering.com/wp-content/uploads/2019/04/innocent-kitten-e1556584502399-1024x1024.jpg", 
                                "Meowasaurus", 
                                LocalDate.of(2015, 1, 1), 
                                tempBreed.getId(), 
                                Gender.MALE, 
                                FurLength.LONG, 
                                "insert bio", 
                                LocalDate.of(2020, 1, 1), 
                                null, 
                                true, 
                                tempAcc.getId())));
                        log.info("Preloading" + catRepo.save(new Cat(
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg", 
                                "Fuzzles", 
                                LocalDate.of(2015, 1, 1), 
                                tempBreed2.getId(), 
                                Gender.MALE, 
                                FurLength.SHORT, 
                                "insert bio", 
                                LocalDate.of(2020, 1, 1), 
                                LocalDate.of(2022, 1, 2), 
                                true, 
                                tempAcc.getId())));
                        log.info("Preloading" + catRepo.save(new Cat(
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/June_odd-eyed-cat_cropped.jpg/712px-June_odd-eyed-cat_cropped.jpg", 
                                "Mr. Meef", 
                                LocalDate.of(2015, 1, 1), 
                                tempBreed2.getId(), 
                                Gender.MALE, 
                                FurLength.LONG, 
                                "insert bio", 
                                LocalDate.of(2020, 1, 1), 
                                LocalDate.of(2022, 1, 2), 
                                true, 
                                tempAcc.getId())));
                        log.info("Preloading" + catRepo.save(new Cat(
                                "https://nationaltoday.com/wp-content/uploads/2019/04/national-siamese-cat-day.jpg", 
                                "Poof", 
                                LocalDate.of(2015, 1, 1), 
                                tempBreed.getId(), 
                                Gender.MALE, 
                                FurLength.LONG, 
                                "insert bio", 
                                LocalDate.of(2020, 1, 1), 
                                LocalDate.of(2022, 1, 2), 
                                true, 
                                tempAcc.getId())));
                        log.info("Preloading" + catRepo.save(new Cat(
                                "https://kittenrescue.org/wp-content/uploads/2019/08/KittenRescue_TinyPanda4-570x570.jpg", 
                                "Rex", 
                                LocalDate.of(2015, 1, 1), 
                                tempBreed.getId(), 
                                Gender.MALE, 
                                FurLength.SHORT, 
                                "insert bio", 
                                LocalDate.of(2020, 1, 1), 
                                LocalDate.of(2022, 1, 2), 
                                true, 
                                tempAcc.getId())));
                        log.info("Preloading" + catRepo.save(new Cat(
                                "https://www.thesprucepets.com/thmb/49Mgi7EXkywd5aRMYnG4mhc4lHI=/960x0/filters:no_upscale():max_bytes(150000):strip_icc()/28153808_150772342209712_8095208665067290624_n-5a949ebcc673350037abdbdc.jpg", 
                                "Socks", 
                                LocalDate.of(2015, 1, 1), 
                                tempBreed.getId(), 
                                Gender.MALE, 
                                FurLength.LONG, 
                                "insert bio", 
                                LocalDate.of(2020, 1, 1), 
                                LocalDate.of(2022, 1, 2), 
                                true, 
                                tempAcc.getId())));
                        log.info("Preloading" + catRepo.save(new Cat(
                                "https://www.rd.com/wp-content/uploads/2019/11/cat-10-e1573844975155-1200x1200.jpg", 
                                "Midnight", 
                                LocalDate.of(2019, 1, 1), 
                                tempBreed.getId(), 
                                Gender.MALE, 
                                FurLength.SHORT, 
                                "insert bio", 
                                LocalDate.of(2020, 1, 1), 
                                LocalDate.of(2022, 1, 2), 
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