package com.purrfectmatch.restservice.model;
// package com.purrfectmatch.restservice;

import org.springframework.stereotype.Component;

@Component
public class ContactPage {
    private String firstName;
    private String lastName;
    private String subject;
    private String email;
    private boolean shelterEmployee;
    private String message;

    ContactPage() {}
    
    public ContactPage(String firstName, String lastName, String subject, 
        String email, boolean shelterEmployee, String message) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.email = email;
        this.shelterEmployee = shelterEmployee;
        this.message = message;
    }

	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public void setName(String name) {
		String[] parts = name.split(" ");
		this.firstName = parts[0];
		this.lastName = parts[1];
    }
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		String[] parts = name.split(" ");
		this.firstName = parts[0];
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
        String[] parts = name.split(" ");
		this.lastName = parts[1];
		
	}
    
    public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
    }
    
    public String getEmailAddress() {
        return email;
    }

    public void setEmailAddress(String email) {
        this.email = email;
    }

    public boolean getShelterEmployee() {
        return shelterEmployee;
    }

    public void setShelterEmployee(boolean shelterEmployee) {
        this.shelterEmployee = shelterEmployee;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactInfo {" +
            ", firstName='" + firstName  + '\'' +
            ", lastName='" + '\'' +
            ", subject='" + subject + '\'' +
            ", email='" + email + '\'' +
            ", shelterEmployee='" + shelterEmployee + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
