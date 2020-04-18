package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Congregacao;
import com.jofre.uapp.repositories.CongregacaoRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class CongregacaoService {
	@Autowired
	private CongregacaoRepository repo;

	public Congregacao find(Integer id) {
		Optional<Congregacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Congregacao.class.getName()));
	}

	public Congregacao insert(Congregacao obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Congregacao update(Congregacao obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}
