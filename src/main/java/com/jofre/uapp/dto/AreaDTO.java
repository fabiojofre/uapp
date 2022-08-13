package com.jofre.uapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.jofre.uapp.domain.Area;

public class AreaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Campo de obrigatório preenchimento")// Beam validation
	@Length(min=1, max=3, message = "Os campos devem conter entre 1 e 3 caractere. Ex: 123")
	private int area;
	private Integer setor;
	
	public AreaDTO() {	
	}
	
	public AreaDTO(Area obj) {
		id = obj.getId();
		area = obj.getArea();
		setor = obj.getSetor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNome() {
		return area;
	}

	public void setNome(Integer area) {
		this.area = area;
	}

	public Integer getSetor() {
		return setor;
	}

	public void setSetor(Integer setor) {
		this.setor = setor;
	}
	
	
}
