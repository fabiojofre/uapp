package com.jofre.uapp.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.jofre.uapp.keys.FrequenciaServicoPK;

@Entity
public class FrequenciaServico implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId //chave composta
	private FrequenciaServicoPK id = new FrequenciaServicoPK();
	
	private Integer frequencia;

	
	public FrequenciaServico() {
	}


	public FrequenciaServico(Servico servico, Pessoa pessoa, Integer frequencia) {
		super();
		id.setServico(servico);
		id.setPessoa(pessoa);
		this.frequencia = frequencia;
	}
	
	public Servico getServico() {
		return id.getServico();
	}
	public Pessoa getPessoa() {
		return id.getPessoa();
	}

	public FrequenciaServicoPK getId() {
		return id;
	}


	public void setId(FrequenciaServicoPK id) {
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
		FrequenciaServico other = (FrequenciaServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
}
