package com.jofre.uapp.dto;

import java.io.Serializable;

import com.jofre.uapp.domain.Usuario;


public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private Integer poder;
	private Integer ativo;
	private String pessoa;
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		senha = obj.getSenha();
		poder = obj.getPoder().getCod();
		ativo = obj.getAtivo().getCod();
		pessoa = obj.getPessoa().getNome();
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

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	
}
