package com.jofre.uapp.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Usuario;
import com.jofre.uapp.repositories.UsuarioRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService es;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		String newPass = newPassword();
		usuario.setSenha(pe.encode(newPass));
		usuarioRepository.save(usuario);
		
		es.sendNewPassord(usuario,newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for(int i = 0;i<10;i++) {
			vet[i]=randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if(opt== 0) {//vou querer gerar um digito
			return (char)(rand.nextInt(10)+ 49);
		}
		else if (opt == 1) {//gera letra maiúscula
			return (char)(rand.nextInt(26)+ 65);
		}
		else {// gera menúscula
			return (char)(rand.nextInt(26)+ 97);
		}
	}
}
