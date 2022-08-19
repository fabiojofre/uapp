package com.jofre.uapp.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jofre.uapp.enums.EnumFrequencia;
import com.jofre.uapp.keys.FrequenciaAcademicoPK;

@Entity
public class FrequenciaAcademico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId //chave composta
	private FrequenciaAcademicoPK id = new FrequenciaAcademicoPK();
	
	private int frequenciaA;
	
	public FrequenciaAcademico() {
	}

	public FrequenciaAcademico(Academico academico, Congregacao congregacao, EnumFrequencia frequenciaA) {
		super();
		id.setAcademico(academico);
		id.setCongregacao(congregacao); 
		this.frequenciaA = frequenciaA.getCod();
	}
	@JsonIgnore
	public Academico getAcademico() {
		return id.getAcademico();
	}
	@JsonIgnoreProperties({"pessoa"})
	public Congregacao getCongregacao() {
		return id.getCongregacao();
	}
	
	
	public FrequenciaAcademicoPK getId() {
		return id;
	}
	public void setId(FrequenciaAcademicoPK id) {
		this.id = id;
	}
	public EnumFrequencia getFrequenciaA() {
		return EnumFrequencia.toEnum(frequenciaA);
	}


	public void setFrequenciaA(EnumFrequencia frequenciaA) {
		this.frequenciaA = frequenciaA.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrequenciaAcademico other = (FrequenciaAcademico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
