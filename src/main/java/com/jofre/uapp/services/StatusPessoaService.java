package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.StatusPessoa;
import com.jofre.uapp.repositories.StatusPessoaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class StatusPessoaService {
	@Autowired
	private StatusPessoaRepository spr;

	public StatusPessoa find(Integer id) throws ObjectNotFoundException{
		Optional<StatusPessoa>obj = spr.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + StatusPessoa.class.getName()));

	}

}
