package com.purrfectmatch.restservice.SuccessStories;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public
class SuccessStory {

  private @Id @GeneratedValue Long id;
  private String imageName, name, age, storyText, breed, gender, adoptionDate, owner;

  public SuccessStory() {

  }

  public SuccessStory(String name, String age) {
    this.name = name;
    this.age = age;
  }

  /*
   * public SuccessStory(String imageName, String name, String age, String
   * storyText, String breed, String gender, String adoptionDate, String owner) {
   * this.imageName = imageName; this.name = name; this.age = age; this.storyText
   * = storyText; this.breed = breed; this.gender = gender; this.adoptionDate =
   * adoptionDate; this.owner = owner; }
   */

  @Override
  public String toString() {
    return String.format(
        "SuccessStory[id=%d, imageName='%s', name='%s', age='%s', storyText='%s', breed='%s', gender='%s', adoptionDate='%s', owner='%s']",
        id, imageName, name, age, storyText, breed, gender, adoptionDate, owner);
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getStoryText() {
    return storyText;
  }

  public void setStoryText(String storyText) {
    this.storyText = storyText;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAdoptionDate() {
    return adoptionDate;
  }

  public void setAdoptionDate(String adoptionDate) {
    this.adoptionDate = adoptionDate;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }
}