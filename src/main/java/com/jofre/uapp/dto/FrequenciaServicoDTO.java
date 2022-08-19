package com.jofre.uapp.dto;

import java.io.Serializable;

import com.jofre.uapp.domain.FrequenciaServico;
import com.jofre.uapp.enums.EnumFrequencia;


public class FrequenciaServicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int frequenciaS;
	private int servicoId;
	private int pessoaId;
	public FrequenciaServicoDTO() {
	}

	public FrequenciaServicoDTO(FrequenciaServico obj) {
		servicoId = obj.getServico().getId();
		pessoaId = obj.getPessoaS().getId();
		frequenciaS = obj.getFrequenciaS().getCod();
	}

	public EnumFrequencia getFrequenciaS() {
		return EnumFrequencia.toEnum(frequenciaS);
	}

	public void setFrequenciaS(EnumFrequencia frequenciaS) {
		this.frequenciaS = frequenciaS.getCod();
	}

	public int getServicoId() {
		return servicoId;
	}

	public void setServicoId(int servicoId) {
		this.servicoId = servicoId;
	}

	public int getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}
	
	
	
}
