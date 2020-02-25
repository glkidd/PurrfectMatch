package com.restservice.model;

import org.springframework.stereotype.Component;

@Component
public class ContactPage {
    private String firstName;
    private String lastName;
    private String subject;
    private String email;
    private String shelterEmployee;
    private String message;

    public enum shelterEmployees {
        Yes,
        No,
    }

    ContactPage() {}
    
    public ContactPage(String firstName, String lastName, String subject, 
        String email, String shelterEmployee, String message) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.email = email;
        this.shelterEmployee = shelterEmployee;
        this.message = message;
    }

  
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {;
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		this.lastName = name;
		
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

    public String getShelterEmployee() {
        return shelterEmployee;
    }

    public void setShelterEmployee(String shelterEmployee) {
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
