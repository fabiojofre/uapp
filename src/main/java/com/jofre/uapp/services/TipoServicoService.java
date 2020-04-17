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
	private TipoServicoRepository tsr;
	
	public TipoServico find(Integer id){
		Optional<TipoServico>obj = tsr.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + TipoServico.class.getName()));

		
	}

}
