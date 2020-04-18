package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.TipoEvento;
import com.jofre.uapp.repositories.TipoEventoRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class TipoEventoService {
	@Autowired
	private TipoEventoRepository repo;
	
	public TipoEvento find(Integer id){
		Optional<TipoEvento>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + TipoEvento.class.getName()));
	}
	public TipoEvento insert(TipoEvento obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public TipoEvento update(TipoEvento obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}