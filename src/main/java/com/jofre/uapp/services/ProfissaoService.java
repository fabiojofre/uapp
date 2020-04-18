package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Profissao;
import com.jofre.uapp.repositories.ProfissaoRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class ProfissaoService {
	@Autowired
	private ProfissaoRepository repo;
	
	public Profissao find(Integer id){
		Optional<Profissao>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Profissao.class.getName()));
	}
	public Profissao insert(Profissao obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Profissao update(Profissao obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	

}
