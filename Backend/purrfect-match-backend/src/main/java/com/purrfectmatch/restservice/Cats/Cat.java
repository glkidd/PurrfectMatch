package com.purrfectmatch.restservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
class Cat {

   private @Id @GeneratedValue Long id;
   private String imageName, name, bio, shelterId;
   private LocalDate bday, dateArrived, euthanizeDate;
   private int breed;
   private Gender gender;
   private FurLength furLength;
   private boolean spayedNeutured;

   private enum Gender {
      MALE, FEMALE, OTHER
   };

   private enum FurLength {
      NOHAIR, SHORT, MEDIUM, LONG
   };

   public Cat() {

   }

   public Cat(String imageName, String name, LocalDate bday, int breed, Gender gender, FurLength furLength, String bio,
         LocalDate dateArrived, LocalDate euthanizeDate, boolean spayedNeutured, String shelterId) {
      this.imageName = imageName;
      this.name = name;
      this.bday = bday;
      this.breed = breed;
      this.gender = gender;
      this.furLength = furLength;
      this.dateArrived = dateArrived;
      this.euthanizeDate = euthanizeDate;
      this.spayedNeutured = spayedNeutured;
      this.shelterId = shelterId;
   }

}