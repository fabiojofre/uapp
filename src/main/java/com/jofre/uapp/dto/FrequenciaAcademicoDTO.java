package com.jofre.uapp.dto;

import java.io.Serializable;

import com.jofre.uapp.domain.FrequenciaAcademico;
import com.jofre.uapp.enums.EnumFrequencia;


public class FrequenciaAcademicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int frequenciaA;
	private int academicoId;
	private int congregacaoId;
	public FrequenciaAcademicoDTO() {
	}

	public FrequenciaAcademicoDTO(FrequenciaAcademico obj) {
		academicoId = obj.getAcademico().getId();
		congregacaoId = obj.getCongregacao().getId();
		frequenciaA = obj.getFrequenciaA().getCod();
	}

	public EnumFrequencia getFrequenciaA() {
		return EnumFrequencia.toEnum(frequenciaA);
	}

	public void setFrequenciaA(EnumFrequencia frequenciaA) {
		this.frequenciaA = frequenciaA.getCod();
	}

	public int getAcademicoId() {
		return academicoId;
	}

	public void setAcademicoId(int academicoId) {
		this.academicoId = academicoId;
	}

	public int getCongregacaoId() {
		return congregacaoId;
	}

	public void setCongregacaoId(int congregacaoId) {
		this.congregacaoId = congregacaoId;
	}
	
	
	
}
