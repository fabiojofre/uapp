package com.jofre.uapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.jofre.uapp.domain.Area;

public class AreaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Campo de obrigatório preenchimento")// Beam validation
	private Integer area;
	@NotEmpty(message = "Campo de obrigatório preenchimento")// Beam validation
	private Integer setorId;
	
	public AreaDTO() {	
	}
	
	public AreaDTO(Area obj) {
		id = obj.getId();
		area = obj.getArea();
		setorId = obj.getSetor().getId();
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

	public Integer getSetorId() {
		return setorId;
	}

	public void setSetorId(Integer setorId) {
		this.setorId = setorId;
	}
	
	
}
