package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Pessoa;
import com.jofre.uapp.repositories.PessoaRepository;

import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoa;
	
	public Pessoa find(Integer id){
		Optional<Pessoa> obj = pessoa.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Pessoa.class.getName()));

		
	}

}
