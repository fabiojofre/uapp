package com.jofre.uapp.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.jofre.uapp.domain.Usuario;


public abstract class AbstractMailService implements EmailService {

	@Value("${default.sender}")
	private String sender;
	
	
	
	@Override
	public void sendOrderConfirmationEmail(Usuario obj) {
		SimpleMailMessage sm = prepareSimpleMailMesssageFromUsuaario(obj);
		sendEmail(sm);
	}

	protected  SimpleMailMessage prepareSimpleMailMesssageFromUsuaario(Usuario obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Confirmação de cadastro IEADPE-EBD");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Parabéns! \nSeu cadastro no IEADPE-EBD foi concluído com sucesso!\nSua senha cadastrada é: "+obj.getSenha());
		return sm;
	}
}