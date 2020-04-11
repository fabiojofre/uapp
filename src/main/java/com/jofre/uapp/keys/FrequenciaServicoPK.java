package com.jofre.uapp.keys;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jofre.uapp.domain.Pessoa;
import com.jofre.uapp.domain.Servico;

@Embeddable // dizer que é um subtipo que armazena as chaves compostas
public class FrequenciaServicoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="servico_id")
	private Servico servico;
	
	@ManyToOne
	@JoinColumn(name="pesoa_id")
	private Pessoa pessoaS;
	
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Pessoa getPessoaS() {
		return pessoaS;
	}
	public void setPessoaS(Pessoa pessoaS) {
		this.pessoaS = pessoaS;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoaS == null) ? 0 : pessoaS.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
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
		FrequenciaServicoPK other = (FrequenciaServicoPK) obj;
		if (pessoaS == null) {
			if (other.pessoaS != null)
				return false;
		} else if (!pessoaS.equals(other.pessoaS))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		return true;
	}

	
}
