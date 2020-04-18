package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Servico;
import com.jofre.uapp.repositories.ServicoRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class ServicoService {
	@Autowired
	private ServicoRepository repo;
	
	public Servico find(Integer id){
		Optional<Servico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Servico.class.getName()));	
	}
	public Servico insert(Servico obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Servico update(Servico obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}
