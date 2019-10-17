package com.jofre.uapp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer area_id;
	private String nome;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "area")
	private List<Congregacao> congregacao;

	public Area() {

	}

	public Area(Integer id, String nome) {
		super();
		this.area_id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return area_id;
	}

	public void setId(Integer id) {
		this.area_id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area_id == null) ? 0 : area_id.hashCode());
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
		if (area_id == null) {
			if (other.area_id != null)
				return false;
		} else if (!area_id.equals(other.area_id))
			return false;
		return true;
	}

}