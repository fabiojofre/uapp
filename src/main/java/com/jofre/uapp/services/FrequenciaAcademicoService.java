package com.jofre.uapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Academico;
import com.jofre.uapp.domain.Congregacao;
import com.jofre.uapp.domain.FrequenciaAcademico;
import com.jofre.uapp.dto.FrequenciaAcademicoDTO;
import com.jofre.uapp.enums.EnumFrequencia;
import com.jofre.uapp.repositories.FrequenciaAcademicoRepository;

@Service
public class FrequenciaAcademicoService {
	
	@Autowired
	private FrequenciaAcademicoRepository repo;
	@Autowired
	private AcademicoService serviceAcademico;
	@Autowired
	private CongregacaoService serviceCongregacao;
	
	public FrequenciaAcademico insert(FrequenciaAcademico obj) {
		obj = repo.save(obj);
		return obj;
		
	}
	public FrequenciaAcademico fromDTO(FrequenciaAcademicoDTO obj) {
		Academico aca = serviceAcademico.find(obj.getAcademicoId());
		Congregacao congreg = serviceCongregacao.find(obj.getCongregacaoId());
		FrequenciaAcademico frequenciaAcademico = new FrequenciaAcademico(aca,congreg,EnumFrequencia.toEnum(obj.getFrequenciaA().getCod()));
		return frequenciaAcademico;
		
	}

}
