package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Congregacao;
import com.jofre.uapp.repositories.CongregacaoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CongregacaoService {
@Autowired
	private CongregacaoRepository cr;
	
public Congregacao find(Integer id) throws ObjectNotFoundException {
	Optional<Congregacao> obj = cr.findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado! Id: "+ id +", tipo: " + Congregacao.class.getName()));
}
	
}
