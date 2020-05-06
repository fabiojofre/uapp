package com.jofre.uapp.keys;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jofre.uapp.domain.Academico;
import com.jofre.uapp.domain.Congregacao;

@Embeddable
public class FrequenciaAcademicoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="academico_id")
	private Academico academico;
	
	@ManyToOne
	@JoinColumn(name="congregacao_id")
	private Congregacao congregacao;

	public Academico getAcademico() {
		return academico;
	}

	public void setAcademico(Academico academico) {
		this.academico = academico;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((academico == null) ? 0 : academico.hashCode());
		result = prime * result + ((congregacao == null) ? 0 : congregacao.hashCode());
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
		FrequenciaAcademicoPK other = (FrequenciaAcademicoPK) obj;
		if (academico == null) {
			if (other.academico != null)
				return false;
		} else if (!academico.equals(other.academico))
			return false;
		if (congregacao == null) {
			if (other.congregacao != null)
				return false;
		} else if (!congregacao.equals(other.congregacao))
			return false;
		return true;
	}
	
	
	
}
