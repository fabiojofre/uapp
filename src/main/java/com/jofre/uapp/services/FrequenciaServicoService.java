package com.jofre.uapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Servico;
import com.jofre.uapp.domain.FrequenciaServico;
import com.jofre.uapp.domain.Pessoa;
import com.jofre.uapp.dto.FrequenciaServicoDTO;
import com.jofre.uapp.enums.EnumFrequencia;
import com.jofre.uapp.repositories.FrequenciaServicoRepository;

@Service
public class FrequenciaServicoService {
	
	@Autowired
	private FrequenciaServicoRepository repo;
	@Autowired
	private ServicoService serviceServico;
	@Autowired
	private PessoaService servicePessoa;
	
	public FrequenciaServico insert(FrequenciaServico obj) {
		obj = repo.save(obj);
		return obj;
		
	}
	public FrequenciaServico fromDTO(FrequenciaServicoDTO obj) {
		Servico servico = serviceServico.find(obj.getServicoId());
		Pessoa pessoa = servicePessoa.find(obj.getPessoaId());
		FrequenciaServico frequenciaServico = new FrequenciaServico(servico,pessoa,EnumFrequencia.toEnum(obj.getFrequenciaS().getCod()));
		return frequenciaServico;
		
	}

}
