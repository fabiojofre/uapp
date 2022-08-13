package com.jofre.uapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer area;
	private Integer setor;

	@OneToMany(mappedBy = "area")
	@JsonIgnoreProperties({"pessoa"})
	private List<Congregacao> congregacao = new ArrayList<>();

	public Area() {

	}

	public Area(Integer id, Integer area, Integer setor) {
		super();
		this.id = id;
		this.area = area;
		this.setor = setor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getSetor() {
		return setor;
	}

	public void setSetor(Integer setor) {
		this.setor = setor;
	}

	public List<Congregacao> getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(List<Congregacao> congregacao) {
		this.congregacao = congregacao;
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
		Area other = (Area) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}