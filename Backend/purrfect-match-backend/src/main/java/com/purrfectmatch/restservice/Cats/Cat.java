package com.purrfectmatch.restservice;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.purrfectmatch.restservice.FurLength;
import com.purrfectmatch.restservice.Gender;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cats")
class Cat {
   @Column(name = "id", nullable = false)
   private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

   @Column(name = "image", nullable = false)
   private String imageName;

   @Column(name = "name")
   private String name;

   @Column(name = "bio")
   private String bio;

   @Column(name = "shelter_id")
   private Long shelterId;

   @Column(name = "birthday")
   private LocalDate bday;

   @Column(name = "date_arrived")
   private LocalDate dateArrived;

   @Column(name = "euthanized_date")
   private LocalDate euthanizeDate;

   @Column(name = "breed")
   private int breed;

   @Column(name = "gender")
   private Gender gender;

   @Column(name = "fur_length")
   private FurLength furLength;

   @Column(name = "spayed/neutured")
   private boolean spayedNeutured;

   public Cat() {

   }

   public Cat(String imageName, String name, LocalDate bday, int breed, Gender gender, FurLength furLength, String bio,
         LocalDate dateArrived, LocalDate euthanizeDate, boolean spayedNeutured, long shelterId) {
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