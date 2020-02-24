package com.purrfectmatch.restservice;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.purrfectmatch.restservice.Species;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "breeds")
class Breed {
   @Column(name = "id")
   private @Id @GeneratedValue Long id;

   @Column(name = "breed_name", unique = true)
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