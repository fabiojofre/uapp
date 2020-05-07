package com.jofre.uapp.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jofre.uapp.enums.EnumFrequencia;
import com.jofre.uapp.keys.FrequenciaEventoPK;

@Entity
public class FrequenciaEvento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId //chave composta
	private FrequenciaEventoPK id = new FrequenciaEventoPK();
	
	private int frequenciaE;

	
	public FrequenciaEvento() {
	}


	public FrequenciaEvento(Evento evento, Pessoa pessoaE, EnumFrequencia frequenciaE) {
		super();
		id.setEvento(evento);
		id.setPessoaE(pessoaE);
		this.frequenciaE = frequenciaE.getCod();
	}
	@JsonIgnore
	public Evento getEvento() {
		return id.getEvento();
	}

	public Pessoa getPessoaE() {
		return id.getPessoaE();
	}

	public FrequenciaEventoPK getId() {
		return id;
	}


	public void setId(FrequenciaEventoPK id) {
		this.id = id;
	}


	public EnumFrequencia getFrequenciaE() {
		return EnumFrequencia.toEnum(frequenciaE);
	}


	public void setFrequencia(EnumFrequencia frequenciaE) {
		this.frequenciaE = frequenciaE.getCod();
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
		FrequenciaEvento other = (FrequenciaEvento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
}
