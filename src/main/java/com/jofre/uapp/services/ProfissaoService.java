package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Profissao;
import com.jofre.uapp.repositories.ProfissaoRepository;

@Service
public class ProfissaoService {
	@Autowired
	private ProfissaoRepository pr;
	
	public Profissao find(Integer id){
		Optional<Profissao>obj = pr.findById(id);
		return obj.orElse(null);
	}
	
	

}
