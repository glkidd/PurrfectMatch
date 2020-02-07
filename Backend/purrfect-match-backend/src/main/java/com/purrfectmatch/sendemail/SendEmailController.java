package com.purrfectmatch.sendemail;
// package com.purrfectmatch.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purrfectmatch.sendemail.ContactPage;
// import com.purrfectmatch.restservice.ContactPage;
import com.purrfectmatch.sendemail.EmailService;
// import com.purrfectmatch.restservice.EmailService;

@RestController
public class SendEmailController {

	@Autowired
	private EmailService notificationService;

	@Autowired
	private ContactPage recipient;

	@RequestMapping("send-mail")
	public String send() {

        recipient.setEmail("purrfectmatch309@gmail.com");
        
		try {
			notificationService.sendEmail(recipient);
        } 
        catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Thank you for contacting us!";
    }
}