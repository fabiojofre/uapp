package com.jofre.uapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Congregacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String responsavel;

	
	@OneToMany(mappedBy = "congregacao")
	private List<Pessoa> pessoa = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "congregacao")
	private List<Servico> servico = new ArrayList<>();

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "area_id")
	private Area area;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.congregacao")
	private Set<FrequenciaAcademico> frequenciaA = new HashSet<>();
	

	public Congregacao() {
	}

	public Congregacao(Integer id, String nome, String responsavel, Area area) {
		super();
		this.id = id;
		this.nome = nome;
		this.responsavel = responsavel;
		this.area = area;
	//this.area = (area == null) ?  null :area.getId(); para tipo enumerado	
	}

	@JsonIgnore
	public List<Academico>getAcademico(){
		List<Academico> lista = new ArrayList<>();
		for(FrequenciaAcademico x: frequenciaA) {
			lista.add(x.getAcademico());
		}
		return lista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}
	
	public Set<FrequenciaAcademico> getFrequenciaA() {
		return frequenciaA;
	}

	public void setFrequenciaA(Set<FrequenciaAcademico> frequenciaA) {
		this.frequenciaA = frequenciaA;
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
		Congregacao other = (Congregacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
