package com.jofre.uapp.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jofre.uapp.services.DBService;

@Configuration
@Profile("dev")
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
}
