package com.jofre.uapp.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jofre.uapp.services.DBService;
import com.jofre.uapp.services.EmailService;
import com.jofre.uapp.services.SmtpEmailService;

@Configuration
@Profile("prod")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}") //pega o valor do properties
	private String Strategy;
	
	@Bean
	public boolean instantiaateDatabase() throws ParseException {
		if(!"create".equals(Strategy)) {
			return false;
		}
		dbService.instantiateTestDatabase();
		return true;
	}
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
