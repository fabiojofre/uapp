package com.jofre.uapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.jofre.uapp.domain.Setor;

public class SetorNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Campo de obrigatório preenchimento")// Beam validation
	private Integer setor;
	@NotEmpty(message = "Campo de obrigatório preenchimento")// Beam validation
	private String nome;
	
	public SetorNewDTO() {	
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSetor() {
		return setor;
	}

	public void setSetor(Integer setor) {
		this.setor = setor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
