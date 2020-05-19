package com.jofre.uapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CongregacaoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min= 2, max = 15, message = "Campo deve conter entre 5 e 15 caracteres" )
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min= 5, max = 15, message = "Campo deve conter entre 5 e 15 caracteres" )
	private String responsavel;
	
	private Integer areaId;
	
	public CongregacaoNewDTO() {
		
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

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
	
}
