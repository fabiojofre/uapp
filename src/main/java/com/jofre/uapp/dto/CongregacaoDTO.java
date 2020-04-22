package com.jofre.uapp.dto;

import java.io.Serializable;

import com.jofre.uapp.domain.Congregacao;

public class CongregacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String responsavel;
	
	public CongregacaoDTO(){
	}
	
	public CongregacaoDTO(Congregacao obj) {
		id = obj.getId();
		nome = obj.getNome();
		responsavel = obj.getResponsavel();
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
	

}
