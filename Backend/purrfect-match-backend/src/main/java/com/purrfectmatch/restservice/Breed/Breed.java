package com.purrfectmatch.restservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
class Breed {

   private @Id @GeneratedValue Long id;
   private String breedName;
   private Species species;

   private enum Species {
      DOG, CAT, OTHER
   };

   public Breed() {

   }

   public Breed(String breedName, Species species) {
      this.breedName = breedName;
      this.species = species;
   }

}