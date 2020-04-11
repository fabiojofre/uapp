package com.jofre.uapp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jofre.uapp.enums.EnumStatusMovimento;


@Entity
public class Academico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String observacao;
	private Integer status;
	private Date data;
	private String concluido;
	
	@ManyToOne
	@JsonBackReference //evita loop de json
	@JoinColumn(name = "tipoAcademico_id")
	private TipoAcademico tipoAcademico;

	
	public Academico() {
	}

	public Academico(Integer id, String observacao, EnumStatusMovimento status, Date data, String concluido,
			Congregacao congergacao, TipoAcademico tipoAcademico) {
		super();
		this.id = id;
		this.observacao = observacao;
		this.status = status.getCod();
		this.data = data;
		this.concluido = concluido;
		this.tipoAcademico = tipoAcademico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public EnumStatusMovimento getStatus() {
		return EnumStatusMovimento.toEnum(status);
	}

	public void setStatus(EnumStatusMovimento status) {
		this.status = status.getCod();
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getConcluido() {
		return concluido;
	}

	public void setConcluido(String concluido) {
		this.concluido = concluido;
	}

	public TipoAcademico getTipoAcademico() {
		return tipoAcademico;
	}

	public void setTipoAcademico(TipoAcademico tipoAcademico) {
		this.tipoAcademico = tipoAcademico;
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
		Academico other = (Academico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
