package com.restservice.MailController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.restservice.ContactPageModel.ContactPage;
import com.restservice.MailService.MailService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MailRegistrationController {

	@Autowired
	private MailService notificationService;

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/contact")
	public String send(@RequestBody @Valid ContactPage contact) {
		try {
			notificationService.sendEmail(contact);
			return "Congratulations! Your mail has been send to the user.";
		} catch (MailException mailException) {
			System.out.println(mailException);
			return "Email could not be sent";
		}
	}
}
