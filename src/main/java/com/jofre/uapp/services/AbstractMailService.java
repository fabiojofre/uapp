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
		SimpleMailMessage sm = prepareSimpleMailMesssageFromUsuario(obj);
		sendEmail(sm);
	}

	protected  SimpleMailMessage prepareSimpleMailMesssageFromUsuario(Usuario obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Confirmação de cadastro IEADPE-EBD");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Parabéns! \nSeu cadastro no IEADPE-EBD foi concluído com sucesso!\nAgora seu acesso está liberado para o trabalho ;)");
		return sm;
	}
	
	@Override
	public void sendNewPassord(Usuario usuario, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(usuario, newPass);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareNewPasswordEmail(Usuario usuario, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(usuario.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Sua nova senha é: "+newPass);
		return sm;
	}
}
