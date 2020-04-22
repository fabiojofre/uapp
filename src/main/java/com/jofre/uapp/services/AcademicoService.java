package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Academico;
import com.jofre.uapp.repositories.AcademicoRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;


@Service
public class AcademicoService {
	@Autowired
	private AcademicoRepository repo;
	
	public Academico find(Integer id) {
		Optional<Academico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Academico.class.getName()));	
	}
	public Academico insert(Academico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Academico update(Academico obj) {
		find(obj.getId());
		return repo.save(obj);
	}


}
