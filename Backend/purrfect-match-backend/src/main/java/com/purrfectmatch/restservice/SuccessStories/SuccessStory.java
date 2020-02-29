package com.purrfectmatch.restservice.SuccessStories;

import lombok.Data;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.purrfectmatch.restservice.Gender;

@Data
@Entity
@Table(name = "success_stories")
public class SuccessStory {
  @Column(name = "id")
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

  @Column(name = "image", nullable = false)
  private String image;

  @Column(name = "name")
  private String name;

  @Column(name = "birthday")
  private LocalDate birthday;

  @Column(name = "breed")
  private int breed;

  @Column(name = "date_adopted", nullable = false)
  private LocalDate dateAdopted;

  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column(name = "message")
  private String message;

  public SuccessStory() {

  }

  // TODO: dummy method for testing.
  public SuccessStory(String name, String message) {
    this.name = name;
    this.message = message;
    this.dateAdopted = LocalDate.of(1998, 5, 21); // dummy
    this.gender = Gender.FEMALE; // dummy
    this.image = "random.png"; // dummy
    this.breed = 4;
  }

  public SuccessStory(String image, String name, LocalDate birthday, int breed, LocalDate dateAdopted, Gender gender,
      String message) {
    this.image = image;
    this.name = name;
    this.birthday = birthday;
    this.breed = breed;
    this.dateAdopted = dateAdopted;
    this.gender = gender;
    this.message = message;
  }
}