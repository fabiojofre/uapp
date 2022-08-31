package com.jofre.uapp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractMailService{

	@Autowired
	private MailSender mailSender;
	
	private static final Logger LOG =LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		
		LOG.info("Simulando LOG de email...");
		mailSender.send(msg);
		LOG.info("Email enviado!!");
		
	}

}
