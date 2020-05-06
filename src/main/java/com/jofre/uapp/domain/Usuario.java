package com.jofre.uapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jofre.uapp.enums.EnumStatusCadastro;
import com.jofre.uapp.enums.EnumUserGrupo;

@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private String poder;
	private Integer ativo;
	
	
	@ManyToOne
	@JsonIgnore //evita loop de json
	@JoinColumn(name = "area_id")
	private Area area;
	
	@ManyToOne
	@JsonIgnore //evita loop de json
	@JoinColumn(name = "congregacao_id")
	private Congregacao congregacao;
	
	
	private Integer userGrupo;
	
	public Usuario() {
	}

	public Usuario(Integer id, String nome, String email, String senha, String poder, EnumStatusCadastro ativo, Area area,
			Congregacao congregacao, EnumUserGrupo userGrupo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.poder = poder;
		this.ativo = ativo.getCod();
		this.area = area;
		this.congregacao = congregacao;
		this.userGrupo = userGrupo.getCod();
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

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}
	public EnumStatusCadastro getAtivo() {
		return EnumStatusCadastro.toEnum(ativo);
	}

	public void setAtivo(EnumStatusCadastro ativo) {
		this.ativo = ativo.getCod();
	}

	public Area getArea() {
		return area;
	}

	public void setId_area(Area area) {
		this.area = area;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setId_congregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public EnumUserGrupo getUserGrupo() {
		return EnumUserGrupo.toEnum(userGrupo);
	}

	public void setUgrupo(EnumUserGrupo userGrupo) {
		this.userGrupo = userGrupo.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
			
}
