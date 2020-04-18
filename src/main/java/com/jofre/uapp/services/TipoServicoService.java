package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.TipoServico;
import com.jofre.uapp.repositories.TipoServicoRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class TipoServicoService {
	@Autowired
	private TipoServicoRepository repo;
	
	public TipoServico find(Integer id){
		Optional<TipoServico>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + TipoServico.class.getName()));
	}
	public TipoServico insert(TipoServico obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public TipoServico update(TipoServico obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}
