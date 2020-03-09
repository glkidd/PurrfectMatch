package com.purrfectmatch.restservice.RecentlyAdopted;

import com.purrfectmatch.restservice.Gender;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "recently_adopted")
public class RecentlyAdopted {
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

  @Column(name = "date_adopted")
  private LocalDate dateAdopted;

  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  private Gender gender;

  public RecentlyAdopted() {
  }

  public RecentlyAdopted(String image, String name, LocalDate birthday, int breed, LocalDate dateAdopted,
      Gender gender) {
    this.image = image;
    this.name = name;
    this.birthday = birthday;
    this.breed = breed;
    this.dateAdopted = dateAdopted;
    this.gender = gender;
  }
}