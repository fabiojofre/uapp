package com.jofre.uapp.dto;

import java.io.Serializable;

import com.jofre.uapp.domain.Usuario;


public class UsuarioNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private Integer poder;
	private Integer ativo;
	private Integer area_id;
	private Integer congregacao_id;
	
	public UsuarioNewDTO() {
	}

	public UsuarioNewDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		senha = obj.getSenha();
		poder = obj.getPoder().getCod();
		ativo = obj.getAtivo().getCod();
		area_id = obj.getArea().getId();
		congregacao_id = obj.getCongregacao().getId();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getPoder() {
		return poder;
	}

	public void setPoder(Integer poder) {
		this.poder = poder;
	}
	public Integer getAtivo() {
		return ativo;
	}
	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Integer getAreaId() {
		return area_id;
	}

	public void setAreaId(Integer area_id) {
		this.area_id = area_id;
	}

	public Integer getCongregacaoId() {
		return congregacao_id;
	}

	public void setCongregacaoId(Integer congregacao_id) {
		this.congregacao_id = congregacao_id;
	}

	
}
