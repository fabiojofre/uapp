package com.jofre.uapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jofre.uapp.enums.EnumStatusMovimento;

@Entity
public class Servico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String observacao;
	private Integer status;
	private Date data;
	
	@ManyToOne
	@JsonBackReference //evita loop de json
	@JoinColumn(name = "tipoServico_id")
	private TipoServico tipoServico;
	
	@ManyToOne
	@JsonBackReference //evita loop de json
	@JoinColumn(name = "congregacao_id")
	private Congregacao congregacao;
	
	@OneToMany(mappedBy = "id.servico")
	private Set<FrequenciaServico> frequenciaS = new HashSet<>();
	
	public Servico() {
	}

	public Servico(Integer id, String observacao, EnumStatusMovimento status, Date data, TipoServico tipoServico,Congregacao congregacao) {
		super();
		this.id = id;
		this.observacao = observacao;
		this.status = status.getCod();
		this.data = data;
		this.tipoServico = tipoServico;
		this.congregacao = congregacao;
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

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}
	
	public Set<FrequenciaServico> getFrequenciaS() {
		return frequenciaS;
	}

	public void setFrequenciaS(Set<FrequenciaServico> frequenciaS) {
		this.frequenciaS = frequenciaS;
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
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
