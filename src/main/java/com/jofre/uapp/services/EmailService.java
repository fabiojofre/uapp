package com.jofre.uapp.services;

import org.springframework.mail.SimpleMailMessage;

import com.jofre.uapp.domain.Usuario;

public interface EmailService {
	void sendOrderConfirmationEmail(Usuario obj);

	void sendEmail(SimpleMailMessage msg);
	}
