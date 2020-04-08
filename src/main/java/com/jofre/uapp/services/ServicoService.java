package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Servico;
import com.jofre.uapp.repositories.ServicoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ServicoService {
	@Autowired
	private ServicoRepository servico;
	
	public Servico find(Integer id) throws ObjectNotFoundException {
		Optional<Servico> obj = servico.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Servico.class.getName()));	
	}

}
