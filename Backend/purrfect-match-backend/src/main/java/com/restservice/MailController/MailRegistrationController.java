package com.restservice.MailController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.restservice.ContactPageModel.ContactPage;
import com.restservice.MailService.MailService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MailRegistrationController {

	@Autowired
	private MailService notificationService;

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/contact")
	@ResponseBody
	public ResponseEntity<String> send(@RequestBody ContactPage contact) {
		String err;
		HttpStatus status;
		try {
			InternetAddress internetAddress = new InternetAddress(contact.getEmail());
			internetAddress.validate();
			notificationService.sendEmail(contact);
			status = HttpStatus.OK;
		}
		catch (AddressException e) {
			err = "Please enter in a valid email.";
			status = HttpStatus.BAD_REQUEST;
			return new ResponseEntity<String>(err, status);
		}
		return new ResponseEntity<String>(status);
	}
}
