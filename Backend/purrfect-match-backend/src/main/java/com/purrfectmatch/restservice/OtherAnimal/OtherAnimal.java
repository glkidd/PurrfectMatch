package com.purrfectmatch.restservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
class OtherAnimal {

   private @Id @GeneratedValue Long id;
   private String imageName, name, bio;
   private LocalDate bday, dateArrived, euthanizeDate;
   private int species; 
   private Gender gender; 
   private boolean spayedNeutured;

   private enum Gender {
      MALE, FEMALE, OTHER
   };

   public OtherAnimal() {

   }

   public OtherAnimal(String imageName, String name, LocalDate bday, int species, Gender gender, 
         String bio, LocalDate dateArrived, LocalDate euthanizeDate, boolean spayedNeutured) {
      this.imageName = imageName;
      this.name = name;
      this.bday = bday;
      this.species = species;
      this.gender = gender;
      this.dateArrived = dateArrived;
      this.euthanizeDate = euthanizeDate;
      this.spayedNeutured = spayedNeutured;
   }
