package com.jofre.uapp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractMailService{
	
	private static final Logger LOG =LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando LOG de email...");
		LOG.info(msg.toString());
		LOG.info("Email enviado!!");
	}

}
