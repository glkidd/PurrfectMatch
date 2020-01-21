package com.purrfectmatch.springjdbcrelationaldataaccess;

public class SuccessStory {
    private long id;
    private String imageName, name, age, storyText, breed, gender, adoptionDate, owner;

    public SuccessStory(long id, String imageName, String name, String age, String storyText, String breed,
                        String gender, String adoptionDate, String owner) {
        this.id = id;
        this.imageName = imageName;
        this.name = name;
        this.age = age;
        this.storyText = storyText;
        this.breed = breed;
        this.gender = gender;
        this.adoptionDate = adoptionDate;
        this.owner = owner;
    }
}


