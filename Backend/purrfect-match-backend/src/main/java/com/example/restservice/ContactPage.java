package com.example.restservice;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ContactPage {
    private String firstName;
    private String lastName;
    private String subject;
    private String email;
    private boolean shelterEmployee;
    private String message;

    public ContactPage(String firstName, String lastName, String subject, 
        String email, boolean shelterEmployee, String message) {
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
    }
    
    public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", subject='" + subject + '\'' +
            ", email='" + email + '\'' +
            ", shelterEmployee='" + shelterEmployee + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}


