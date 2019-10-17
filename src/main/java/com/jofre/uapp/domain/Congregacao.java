package com.jofre.uapp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Congregacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer congregacao_id;
	private String nome;
	private String responsavel;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "congregacao") // Define uma estrategia de um para muitos,em
																	// mapeamento preguiçosa na tabela definida
	private List<Pessoa> pessoa; // traz uma lista de desse mapeamento

	@ManyToOne(fetch = FetchType.LAZY) // Define uma estrategia de muitos para um,em mapeamento preguiçosa em uma
										// tabela secundário usando o id
	@JoinColumn(name = "area_id")
	private Area area;

	public Congregacao() {
	}

	public Congregacao(Integer id, String nome, String responsavel) {
		super();
		this.congregacao_id = id;

		this.nome = nome;
		this.responsavel = responsavel;
	}

	public Integer getCongregacaoId() {
		return congregacao_id;
	}

	public void setCongregacaoId(Integer id) {
		this.congregacao_id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((congregacao_id == null) ? 0 : congregacao_id.hashCode());
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
		Congregacao other = (Congregacao) obj;
		if (congregacao_id == null) {
			if (other.congregacao_id != null)
				return false;
		} else if (!congregacao_id.equals(other.congregacao_id))
			return false;
		return true;
	}

}
