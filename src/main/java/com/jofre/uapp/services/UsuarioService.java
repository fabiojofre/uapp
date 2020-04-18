package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Usuario;
import com.jofre.uapp.repositories.UsuarioRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(Integer id){
		Optional<Usuario>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Usuario.class.getName()));	
	}
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Usuario update(Usuario obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}
