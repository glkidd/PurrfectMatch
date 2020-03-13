package com.purrfectmatch.restservice.ContactPageModel;

import lombok.Data;

import org.springframework.stereotype.Component;

@Data
@Component
public class ContactPage {
    private String firstName;
    private String lastName;
    private String subject;
    private String email;

    private ShelterEmployee shelterEmployee;
    private String message;

    public enum ShelterEmployee {
        YES, NO
    }

    ContactPage() {
    }

    public ContactPage(String firstName, String lastName, String subject, String email, ShelterEmployee shelterEmployee,
            String message) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.email = email;
        this.shelterEmployee = shelterEmployee;
        this.message = message;
    }

    @Override
    public String toString() {

        return String.format("First Name:%s\nLastName:%s \nEmail:%s\nShelterEmployee:%s\nMessage:%s", firstName,
                lastName, email, shelterEmployee, message);

    }
}
