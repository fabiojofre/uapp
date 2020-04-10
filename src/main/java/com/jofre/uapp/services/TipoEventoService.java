package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.TipoEvento;
import com.jofre.uapp.repositories.TipoEventoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class TipoEventoService {
	@Autowired
	private TipoEventoRepository ter;
	
	public TipoEvento find(Integer id) throws ObjectNotFoundException {
		Optional<TipoEvento>obj = ter.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + TipoEvento.class.getName()));

		
	}

}
