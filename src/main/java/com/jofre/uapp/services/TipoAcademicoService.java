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
	private TipoAcademicoRepository tar;
	
	public TipoAcademico find(Integer id){
		Optional<TipoAcademico> obj = tar.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + TipoAcademico.class.getName()));

			
	}

}
