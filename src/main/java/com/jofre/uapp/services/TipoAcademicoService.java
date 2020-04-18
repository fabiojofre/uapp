package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.TipoAcademico;
import com.jofre.uapp.repositories.TipoAcademicoRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class TipoAcademicoService {
	@Autowired
	private TipoAcademicoRepository repo;
	
	public TipoAcademico find(Integer id){
		Optional<TipoAcademico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + TipoAcademico.class.getName()));		
	}
	public TipoAcademico insert(TipoAcademico obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public TipoAcademico update(TipoAcademico obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}