package com.purrfectmatch.restservice.controller;

//import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purrfectmatch.restservice.model.ContactPage;
import com.purrfectmatch.restservice.service.MailService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 //Mail API using Spring Boot
@RestController
public class RegistrationController {

	@Autowired
	private MailService notificationService;

	

	
	
	@CrossOrigin(origins = "http://localhost:3001")
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

/*
	@RequestMapping("send-mail-attachment")
	public String sendWithAttachment() throws MessagingException {

	
		user.setFirstName("John Doe");
		user.setLastName("John Doe");
		user.setEmailAddress("purrfectmatch309@gmail.com"); //Receiver's email address

	
		 //Here we will call sendEmailWithAttachment() for Sending mail to the sender that contains an attachment.
		 
		try {
			notificationService.sendEmailWithAttachment(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
	*/
}
