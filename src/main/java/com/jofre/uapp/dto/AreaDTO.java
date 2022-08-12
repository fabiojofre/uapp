package com.jofre.uapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.jofre.uapp.domain.Area;

public class AreaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Campo de obrigatório preenchimento")// Beam validation
	@Length(min=5, max=9, message = "Os campos devem conter entre 5 e 9 caractere. Ex: Area III")
	private String nome;
	private Integer setor;
	
	public AreaDTO() {	
	}
	
	public AreaDTO(Area obj) {
		id = obj.getId();
		nome = obj.getNome();
		setor = obj.getSetor();
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

	public Integer getSetor() {
		return setor;
	}

	public void setSetor(Integer setor) {
		this.setor = setor;
	}
	
	
}
