package com.jofre.uapp.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jofre.uapp.enums.EnumFrequencia;
import com.jofre.uapp.keys.FrequenciaServicoPK;

@Entity
public class FrequenciaServico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId //chave composta
	private FrequenciaServicoPK id = new FrequenciaServicoPK();
	
	private int frequenciaS;

	
	public FrequenciaServico() {
	}

	public FrequenciaServico(Servico servico, Pessoa pessoaS, EnumFrequencia frequenciaS) {
		super();
		id.setServico(servico);
		id.setPessoaS(pessoaS);
		this.frequenciaS = frequenciaS.getCod();
	}
	@JsonIgnore
	public Servico getServico() {
		return id.getServico();
	}
	public Pessoa getPessoaS() {
		return id.getPessoaS();
	}
	
	public FrequenciaServicoPK getId() {
		return id;
	}


	public void setId(FrequenciaServicoPK id) {
		this.id = id;
	}


	public EnumFrequencia getFrequenciaS() {
		return EnumFrequencia.toEnum(frequenciaS);
	}


	public void setFrequenciaS(EnumFrequencia frequenciaS) {
		this.frequenciaS = frequenciaS.getCod();
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
		FrequenciaServico other = (FrequenciaServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
}
