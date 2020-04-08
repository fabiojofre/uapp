package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Evento;
import com.jofre.uapp.repositories.EventoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EventoService {
	@Autowired
	private EventoRepository evento;
	
	public Evento find(Integer id) throws ObjectNotFoundException {
		Optional<Evento> obj = evento.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Evento.class.getName()));

		
	}

}
