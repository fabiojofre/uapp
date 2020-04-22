package com.jofre.uapp.dto;

import java.io.Serializable;

import com.jofre.uapp.domain.Profissao;

public class ProfissaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String profissao;
	
	public ProfissaoDTO() {
	}
	public ProfissaoDTO(Profissao obj) {
		id = obj.getId();
		profissao = obj.getProfissao();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
}
