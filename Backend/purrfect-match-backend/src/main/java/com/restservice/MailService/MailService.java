package com.restservice.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.restservice.ContactPageModel.ContactPage;


@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	public void sendEmail(final ContactPage user) throws MailException {
		   SimpleMailMessage mail = new SimpleMailMessage();
		   String info = user.toString();
		   mail.setTo("purrfectmatch309@gmail.com");
		   mail.setSubject(user.getSubject());
		   mail.setText(info);
			javaMailSender.send(mail);
	}
}
