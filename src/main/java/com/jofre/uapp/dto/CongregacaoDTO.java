package com.jofre.uapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.jofre.uapp.domain.Congregacao;

public class CongregacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min= 5, max = 55, message = "Campo deve conter entre 5 e 55 caracteres" )
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min= 5, max = 55, message = "Campo deve conter entre 5 e 55 caracteres" )
	private String responsavel;
	private int areaId;
	
	public CongregacaoDTO(){
	}
	
	public CongregacaoDTO(Congregacao obj) {
		id = obj.getId();
		nome = obj.getNome();
		responsavel = obj.getResponsavel();
		areaId = obj.getArea().getArea();
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
	public int getAreaId() {
		return areaId;
	}
	public void setArea(int area) {
		this.areaId = area;
	}
	
}
