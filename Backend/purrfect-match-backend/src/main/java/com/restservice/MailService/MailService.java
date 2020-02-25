package com.restservice.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.restservice.ContactPageModel.ContactPage;


@Service
public class MailService {

	
	// Sends through the JavaMailSender interface through springboot and allows auto-configuration
	private JavaMailSender javaMailSender;

	
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	
	public void sendEmail(ContactPage user) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		String info ="Name: "+user.getFirstName()+" "+user.getLastName()+"\nEmail:"+user.getEmailAddress()+"\n"+"ShelterEmployee: "+ user.getShelterEmployee()+"\n\nMessage: \n"+user.getMessage();
		
		mail.setTo("purrfectmatch309@gmail.com");
		mail.setSubject(user.getSubject());
		mail.setText(info);
		
		javaMailSender.send(mail);
	}
}
