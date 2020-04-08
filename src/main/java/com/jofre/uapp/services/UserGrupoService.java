package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.UserGrupo;
import com.jofre.uapp.repositories.UserGrupoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UserGrupoService {
	@Autowired
	private UserGrupoRepository ugr;
	
	public UserGrupo find(Integer id) throws ObjectNotFoundException {
		Optional<UserGrupo>obj = ugr.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + UserGrupo.class.getName()));

		
	}

}
