package com.jofre.uapp.dto;

import java.io.Serializable;

import com.jofre.uapp.domain.Usuario;
import com.jofre.uapp.enums.EnumPoder;
import com.jofre.uapp.enums.EnumStatusCadastro;


public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String cpf;
	private String cartaodemembro;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private Integer poder;
	private Integer ativo;
	private Integer congregacaoId;
	private Integer profissaoId;
	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		cpf = obj.getCpf();
		cartaodemembro = obj.getCartaodemembro();
		nome = obj.getNome();
		email = obj.getEmail();
		senha = obj.getSenha();
		telefone = obj.getTelefone();
		poder = obj.getPoder().getCod();
		ativo = obj.getAtivo().getCod();
		congregacaoId = obj.getCongregacao().getId();
		profissaoId = obj.getProfissao().getId();
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

	public void setAtivo(EnumStatusCadastro ativo) {
		this.ativo = ativo.getCod();
	}

	public Integer getCongregacaoId() {
		return congregacaoId;
	}

	public void setCongregacaoId(Integer congregacaoId) {
		this.congregacaoId = congregacaoId;
	}

	public Integer getProfissaoId() {
		return profissaoId;
	}

	public void setProfissaoId(Integer profissaoId) {
		this.profissaoId = profissaoId;
	}


}
