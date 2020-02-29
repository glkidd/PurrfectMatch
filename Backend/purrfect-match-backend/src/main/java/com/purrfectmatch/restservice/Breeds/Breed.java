package com.purrfectmatch.restservice.Breeds;

import com.purrfectmatch.restservice.Species;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "breeds")
public class Breed {
   @Column(name = "id", nullable = false)
   private @Id @GeneratedValue Long id;

   @Column(name = "breed_name", nullable = false, unique = true)
   private String breedName;

   @Column(name = "species")
   @Enumerated(EnumType.STRING)
   private Species species;

   public Breed() {

   }

   public Breed(String breedName, Species species) {
      this.breedName = breedName;
      this.species = species;
   }

}