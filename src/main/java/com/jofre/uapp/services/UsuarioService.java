package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Usuario;
import com.jofre.uapp.repositories.UsuarioRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository ur;
	
	public Usuario find(Integer id) throws ObjectNotFoundException {
		Optional<Usuario>obj = ur.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Usuario.class.getName()));

		
	}

}
