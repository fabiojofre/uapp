package com.jofre.uapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


public class UsuarioNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min= 5, max = 15, message = "Campo deve conter entre 5 e 15 caracteres" )
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min= 5, max = 150, message = "Campo deve conter entre 5 e 150 caracteres" )
	private String email;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min= 4, max = 10, message = "Campo deve conter entre 4 e 10 caracteres" )
	private String senha;
	private Integer poder;
	private Integer ativo;
	private Integer pessoaId;
	
	public UsuarioNewDTO() {
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

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}
}
