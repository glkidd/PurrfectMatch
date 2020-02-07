package com.purrfectmatch.sendemail;
// package com.purrfectmatch.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.purrfectmatch.sendemail.ContactPage;
// import com.purrfectmatch.restservice.ContactPage;

@Service
public class EmailService {
    
    private JavaMailSender javaMailSender;
    
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(ContactPage info) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(info.getEmail());
		mail.setSubject("test");
		mail.setText("test");

		javaMailSender.send(mail);
	}

}