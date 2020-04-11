package com.jofre.uapp.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.jofre.uapp.keys.FrequenciaEventoPK;

@Entity
public class FrequenciaEvento implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId //chave composta
	private FrequenciaEventoPK id = new FrequenciaEventoPK();
	
	private Integer frequencia;

	
	public FrequenciaEvento() {
	}


	public FrequenciaEvento(Evento evento, Pessoa pessoa, Integer frequencia) {
		super();
		id.setEvento(evento);
		id.setPessoa(pessoa);
		this.frequencia = frequencia;
	}
	
	public Evento getEvento() {
		return id.getEvento();
	}
	public Pessoa getPessoa() {
		return id.getPessoa();
	}

	public FrequenciaEventoPK getId() {
		return id;
	}


	public void setId(FrequenciaEventoPK id) {
		this.id = id;
	}


	public Integer getFrequencia() {
		return frequencia;
	}


	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
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
