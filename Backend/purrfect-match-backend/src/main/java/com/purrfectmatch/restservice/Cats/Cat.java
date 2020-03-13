package com.purrfectmatch.restservice.Cats;

import com.purrfectmatch.restservice.FurLength;
import com.purrfectmatch.restservice.Gender;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cats")
public class Cat {
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
   @Enumerated(EnumType.STRING)
   private Gender gender;

   @Column(name = "fur_length")
   @Enumerated(EnumType.STRING)
   private FurLength furLength;

   @Column(name = "spayed_neutured")
   private boolean spayedNeutured;

   public Cat() {

   }

   public Cat(String imageName, String name, LocalDate bday, Long breed, Gender gender, FurLength furLength, String bio,
         LocalDate dateArrived, LocalDate euthanizeDate, boolean spayedNeutured, long shelterId) {
      this.imageName = imageName;
      this.name = name;
      this.bday = bday;
      this.breed = breed.intValue();
      this.gender = gender;
      this.furLength = furLength;
      this.bio = bio;
      this.dateArrived = dateArrived;
      this.euthanizeDate = euthanizeDate;
      this.spayedNeutured = spayedNeutured;
      this.shelterId = shelterId;
   }

}