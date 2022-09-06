package com.jofre.uapp.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jofre.uapp.enums.EnumPoder;
import com.jofre.uapp.enums.EnumStatusCadastro;

@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique =true)
	private String cpf;
	private String cartaodemembro;
	private String nome;
	@Column(unique =true)
	private String email;
	
	@JsonIgnore
	private String senha;
	private String telefone;
	private Integer poder;
	private Integer ativo;
	@ManyToOne
	@JoinColumn(name = "congregacao_id")
	private Congregacao congregacao;
	
	@ManyToOne
	@JoinColumn(name = "profissao_id")
	private Profissao profissao;

	public Usuario() {
	}



	public Usuario(Integer id, String cpf, String cartaodemembro, String nome, String email, String senha,
			String telefone, EnumPoder  poder, EnumStatusCadastro  ativo, Congregacao congregacao,Profissao profissao) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.cartaodemembro = cartaodemembro;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.poder = poder.getCod();
		this.ativo = ativo.getCod();
		this.congregacao = congregacao;
		this.profissao = profissao;
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


	
	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}



	public Profissao getProfissao() {
		return profissao;
	}



	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
