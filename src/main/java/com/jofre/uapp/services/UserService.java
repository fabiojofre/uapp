package com.jofre.uapp.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.jofre.uapp.security.UserSS;

public class UserService {

	public static UserSS auhenticated() {
		try {
		return (UserSS)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); //retorna usuário logado
		}catch(Exception e) {
			
			return null;
		}
	}
}
