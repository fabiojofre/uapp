package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.TipoPessoa;
import com.jofre.uapp.repositories.TipoPessoaRepository;

import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class TipoPessoaService {
	@Autowired
	private TipoPessoaRepository tpr;
	
	public TipoPessoa find(Integer id){
		Optional<TipoPessoa>obj = tpr.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + TipoPessoa.class.getName()));

		
	}

}
