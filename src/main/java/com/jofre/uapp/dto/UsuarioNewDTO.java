package com.jofre.uapp.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.jofre.uapp.enums.EnumPoder;
import com.jofre.uapp.enums.EnumSituacaoPessoa;
import com.jofre.uapp.enums.EnumStatusCadastro;


public class UsuarioNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	//@CPF(message="CPF inválido")
	private String cpf;
	@NotEmpty(message="Preenchimento obrigatório")
	private String cartaodemembro;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min= 5, max = 55, message = "Campo deve conter entre 5 e 55 caracteres" )
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	private String telefone;
	//@NotEmpty(message="Preenchimento obrigatório")
	private Integer poder;
	private Integer ativo;
	private Integer congregacaoId;
	
	public UsuarioNewDTO() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCartaodemembro() {
		return cartaodemembro;
	}

	public void setCartaodemembro(String cartaodemembro) {
		this.cartaodemembro = cartaodemembro;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnumPoder getPoder() {
		return EnumPoder.toEnum(poder);
	}

	public void setPoder(EnumPoder poder) {
		this.poder = poder.getCod();
	}

	public EnumStatusCadastro getAtivo() {
		return EnumStatusCadastro.toEnum(ativo);
	}

	public void setAtivo(EnumStatusCadastro
			ativo) {
		this.ativo = ativo.getCod();
	}

	public Integer getCongregacaoId() {
		return congregacaoId;
	}

	public void setCongregacaoId(Integer congregacaoId) {
		this.congregacaoId = congregacaoId;
	}

}
