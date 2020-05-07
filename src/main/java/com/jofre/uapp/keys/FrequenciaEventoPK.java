package com.jofre.uapp.keys;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jofre.uapp.domain.Evento;
import com.jofre.uapp.domain.Pessoa;

@Embeddable // dizer que é um subtipo que armazena as chaves compostas
public class FrequenciaEventoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="evento_id")
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name="pesoa_id")
	private Pessoa pessoaE;
	
	public Evento getEvento() {
		return evento;
	}
	
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public Pessoa getPessoaE() {
		return pessoaE;
	}
	
	public void setPessoaE(Pessoa pessoaE) {
		this.pessoaE = pessoaE;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoaE == null) ? 0 : pessoaE.hashCode());
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
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
		FrequenciaEventoPK other = (FrequenciaEventoPK) obj;
		if (pessoaE == null) {
			if (other.pessoaE != null)
				return false;
		} else if (!pessoaE.equals(other.pessoaE))
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		return true;
	}

	
}
