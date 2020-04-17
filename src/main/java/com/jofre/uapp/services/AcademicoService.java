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
	private AcademicoRepository ar;
	
	public Academico find(Integer id) {
		Optional<Academico> obj = ar.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Academico.class.getName()));

			
	}

}
