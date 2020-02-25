package com.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RestController;

import com.restservice.model.ContactPage;
import com.restservice.service.MailService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 //Mail API using Spring Boot
@RestController
public class RegistrationController {

	@Autowired
	private MailService notificationService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/contact")

	public String send(@RequestBody ContactPage contact) {


		//Creating a User with the help of User class that we have declared. 
		//Sets the First,Last and Email address of the sender.
		 //Receiver's email address

		 //Here we will call sendEmail() for Sending mail to the sender.
		try {
			notificationService.sendEmail(contact);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
}
