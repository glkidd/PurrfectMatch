package com.purrfectmatch.restservice;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.purrfectmatch.restservice.FurLength;
import com.purrfectmatch.restservice.Gender;
import com.purrfectmatch.restservice.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "dogs")
class Dog {
   @Column(name = "id")
   private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

   @Column(name = "image")
   private String imageName;

   @Column(name = "name")
   private String name;

   @Column(name = "birthday")
   private LocalDate bday;

   @Column(name = "breed")
   private int breed;

   @Column(name = "gender")
   private Gender gender;

   @Column(name = "fur_length")
   private FurLength furLength;

   @Column(name = "bio")
   private String bio;

   @Column(name = "date_arrived")
   private LocalDate dateArrived;
   
   @Column(name = "shelter_id")
   private long shelterId;

   @Column(name = "euthanized_date")
   private LocalDate euthanizeDate;

   @Column(name = "spayed/neutured")
   private boolean spayedNeutured;

   @Column(name = "size")
   private Size size;

   public Dog() {

   }

   public Dog(String imageName, String name, LocalDate bday, int breed, Gender gender, FurLength furLength, String bio,
         LocalDate dateArrived, LocalDate euthanizeDate, boolean spayedNeutured, Size size, long shelterId) {
      this.imageName = imageName;
      this.name = name;
      this.bday = bday;
      this.breed = breed;
      this.gender = gender;
      this.furLength = furLength;
      this.dateArrived = dateArrived;
      this.euthanizeDate = euthanizeDate;
      this.spayedNeutured = spayedNeutured;
      this.size = size;
      this.shelterId = shelterId;
   }

}
