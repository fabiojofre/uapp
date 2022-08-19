package com.jofre.uapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Evento;
import com.jofre.uapp.domain.FrequenciaEvento;
import com.jofre.uapp.domain.Pessoa;
import com.jofre.uapp.dto.FrequenciaEventoDTO;
import com.jofre.uapp.enums.EnumFrequencia;
import com.jofre.uapp.repositories.FrequenciaEventoRepository;

@Service
public class FrequenciaEventoService {
	
	@Autowired
	private FrequenciaEventoRepository repo;
	@Autowired
	private EventoService serviceEvento;
	@Autowired
	private PessoaService servicePessoa;
	
	public FrequenciaEvento insert(FrequenciaEvento obj) {
		obj = repo.save(obj);
		return obj;
		
	}
	public FrequenciaEvento fromDTO(FrequenciaEventoDTO obj) {
		Evento evento = serviceEvento.find(obj.getEventoId());
		Pessoa pessoa = servicePessoa.find(obj.getPessoaId());
		FrequenciaEvento frequenciaEvento = new FrequenciaEvento(evento,pessoa,EnumFrequencia.toEnum(obj.getFrequenciaE().getCod()));
		return frequenciaEvento;
		
	}

}
