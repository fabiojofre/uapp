package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.UserGrupo;
import com.jofre.uapp.repositories.UserGrupoRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class UserGrupoService {
	@Autowired
	private UserGrupoRepository repo;
	
	public UserGrupo find(Integer id){
		Optional<UserGrupo>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + UserGrupo.class.getName()));	
	}
	public UserGrupo insert(UserGrupo obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public UserGrupo update(UserGrupo obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}
