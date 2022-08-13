package com.jofre.uapp.dto;

import java.io.Serializable;

import com.jofre.uapp.domain.TipoServico;

public class TipoServicoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String desc1;
	private String desc2;
	
	
	public TipoServicoDTO() {
	}

	public TipoServicoDTO(TipoServico obj) {
		super();
		id = obj.getId();
		desc1 = obj.getDesc1();
		desc2 = obj.getDesc2();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getDesc2() {
		return desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}
	
	
	
}
