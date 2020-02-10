package com.purrfectmatch.restservice;

import lombok.Data;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class SuccessStory {

  private enum Gender {
    MALE, FEMALE, OTHER
  };

  private @Id @GeneratedValue Long id;
  private String image;
  private String name;
  private Date birthday;
  private int breed;
  private Date dateAdopted;
  private Gender gender;
  private String message;

  public SuccessStory() {

  }

  public SuccessStory(String name, String message) {
    this.name = name;
    this.message = message;
  }

  public SuccessStory(String image, String name, Date birthday, int breed, Date dateAdopted, Gender gender,
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