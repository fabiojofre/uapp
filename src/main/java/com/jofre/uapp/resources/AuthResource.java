package com.jofre.uapp.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jofre.uapp.dto.EmailDTO;
import com.jofre.uapp.security.JWTUtil;
import com.jofre.uapp.security.UserSS;
import com.jofre.uapp.services.AuthService;
import com.jofre.uapp.services.UserService;

@RestController
@RequestMapping(value="/auth")
public class AuthResource {
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	AuthService auth;
	
	@RequestMapping(value="/refresh_token",method=RequestMethod.POST)
	public ResponseEntity<Void>refreshToken(HttpServletResponse response){
		UserSS user = UserService.auhenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization","Bearer "+token);
		response.addHeader("access-control-expose-headers","Authorization");
		return ResponseEntity.noContent().build();
		
	}

	@RequestMapping(value="/forgot",method=RequestMethod.POST)
	public ResponseEntity<Void>forgot(@Valid @RequestBody EmailDTO objDTO){
		auth.sendNewPassword(objDTO.getEmail());
		return ResponseEntity.noContent().build();
	}
}
