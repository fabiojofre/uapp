package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.StatusPessoa;
import com.jofre.uapp.repositories.StatusPessoaRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class StatusPessoaService {
	@Autowired
	private StatusPessoaRepository repo;

	public StatusPessoa find(Integer id){
		Optional<StatusPessoa>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + StatusPessoa.class.getName()));
	}
	public StatusPessoa insert(StatusPessoa obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public StatusPessoa update(StatusPessoa obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}
