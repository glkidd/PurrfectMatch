package com.purrfectmatch.restservice;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.purrfectmatch.restservice.Gender;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "other_animals")
class OtherAnimal {
   @Column(name = "id")
   private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

   @Column(name = "image")
   private String imageName;

   @Column(name = "name")
   private String name;

   @Column(name = "birthday")
   private LocalDate bday;

   @Column(name = "species")
   private int species;

   @Column(name = "gender")
   private Gender gender;

   @Column(name = "bio")
   private String bio;

   @Column(name = "shelter_id")
   private Long shelterId;

   @Column(name = "date_arrived")
   private LocalDate dateArrived;

   @Column(name = "euthanized_date")
   private LocalDate euthanizeDate;

   @Column(name = "spayed/neutured")
   private boolean spayedNeutured;

   public OtherAnimal() {

   }

   public OtherAnimal(String imageName, String name, LocalDate bday, int species, Gender gender, String bio,
         LocalDate dateArrived, LocalDate euthanizeDate, boolean spayedNeutured, long shelterId) {
      this.imageName = imageName;
      this.name = name;
      this.bday = bday;
      this.species = species;
      this.gender = gender;
      this.dateArrived = dateArrived;
      this.euthanizeDate = euthanizeDate;
      this.spayedNeutured = spayedNeutured;
      this.shelterId = shelterId;
   }

}