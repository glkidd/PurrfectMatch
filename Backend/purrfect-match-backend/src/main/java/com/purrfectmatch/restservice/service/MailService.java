package com.purrfectmatch.restservice.service;

//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.purrfectmatch.restservice.model.ContactPage;


@Service
public class MailService {

	
	// Sends through the JavaMailSender interface through springboot and allows auto-configuration
	private JavaMailSender javaMailSender;

	
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	
	public void sendEmail(ContactPage user) throws MailException {

		//JavaMailSender Interface allows emails to be sent through Spring Boot
		//JavaMailSender is extended through the MailSender Interface and contains send() function
		//SimpleMailMessage Object is required because send() function uses object of SimpleMailMessage as a Parameter
		
		SimpleMailMessage mail = new SimpleMailMessage();
		String info ="Name: "+user.getFirstName()+" "+user.getLastName()+"\n"+user.getEmailAddress()+"\n"+"ShelterEmployee: "+ user.getShelterEmployee()+"\n\nMessage: \n"+user.getMessage();
		
		mail.setTo("purrfectmatch309@gmail.com");
		mail.setSubject(user.getSubject());
		mail.setText(info);
		
		//mail.setText(user.getMessage()+);
		
		//This send() contains an Object of SimpleMailMessage as an Parameter
	
		javaMailSender.send(mail);
	}

	//Function sends an attachment
	/*
	public void sendEmailWithAttachment(ContactPage user) throws MailException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		String info ="Name: "+user.getFirstName()+user.getLastName()+"\n"+user.getEmailAddress()+"\n"+"ShelterEmployee:"+ user.getShelterEmployee()+"\nMessage: \n"+user.getMessage();

		helper.setTo("purrfectmatch309@gmail.com");
		helper.setSubject(user.getSubject());
		helper.setText(info);

		
		ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);

		javaMailSender.send(message);
	}
	*/

}
