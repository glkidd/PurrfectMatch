package com.purrfectmatch.restservice;

import lombok.Data;

import java.sql.Date;

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
@Table(name = "recently_adopted")
class RecentlyAdopted {
  @Column(name = "id")
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

  @Column(name = "image", nullable = false)
  private String image;

  @Column(name = "name")
  private String name;

  @Column(name = "birthday")
  private Date birthday;

  @Column(name = "breed")
  private int breed;

  @Column(name = "date_adopted")
  private Date dateAdopted;

  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  private Gender gender;

  RecentlyAdopted() {
  }

  RecentlyAdopted(String image, String name, Date birthday, int breed, Date dateAdopted, Gender gender) {
    this.image = image;
    this.name = name;
    this.birthday = birthday;
    this.breed = breed;
    this.dateAdopted = dateAdopted;
    this.gender = gender;
  }
}