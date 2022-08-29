package com.jofre.uapp.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jofre.uapp.enums.EnumPoder;
import com.jofre.uapp.enums.EnumStatusCadastro;

@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cpf;
	private String cartaodemembro;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private Integer poder;
	private Integer ativo;
	@ManyToOne
	@JoinColumn(name = "congregacao_id")
	private Congregacao congregacao;

	public Usuario() {
	}

	public Usuario(Integer id, EnumStatusCadastro ativo, String cartaodemembro, Congregacao congregacao, String cpf, String email, String nome, EnumPoder poder, String senha,
			String telefone) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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
