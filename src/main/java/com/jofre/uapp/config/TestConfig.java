package com.jofre.uapp.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jofre.uapp.services.DBService;
import com.jofre.uapp.services.EmailService;
import com.jofre.uapp.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	@Bean
	public boolean instantiaateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	//descomentar se for enviar email de teste
//	@Bean
//	public EmailService emailService() {
//		return new SmtpEmailService();
//	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
	
}
