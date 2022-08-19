package com.jofre.uapp.dto;

import java.io.Serializable;

import com.jofre.uapp.domain.FrequenciaEvento;
import com.jofre.uapp.enums.EnumFrequencia;


public class FrequenciaEventoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int frequenciaE;
	private int eventoId;
	private int pessoaId;
	public FrequenciaEventoDTO() {
	}

	public FrequenciaEventoDTO(FrequenciaEvento obj) {
		eventoId = obj.getEvento().getId();
		pessoaId = obj.getPessoaE().getId();
		frequenciaE = obj.getFrequenciaE().getCod();
	}

	public EnumFrequencia getFrequenciaE() {
		return EnumFrequencia.toEnum(frequenciaE);
	}

	public void setFrequenciaE(EnumFrequencia frequenciaE) {
		this.frequenciaE = frequenciaE.getCod();
	}

	public int getEventoId() {
		return eventoId;
	}

	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}

	public int getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}
	
	
	
}
