package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Evento;
import com.jofre.uapp.repositories.EventoRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class EventoService {
	@Autowired
	private EventoRepository repo;
	
	public Evento find(Integer id) {
		Optional<Evento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Evento.class.getName()));
	}
	
	public Evento insert(Evento obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Evento update(Evento obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}
