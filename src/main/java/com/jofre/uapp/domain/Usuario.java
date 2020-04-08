package com.jofre.uapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private Integer id_area;
	private Integer id_congregacao;
	
	@ManyToOne
	@JsonBackReference //evita loop de json
	@JoinColumn(name = "ugrupo_id")
	private Ugrupo ugrupo;
	
	public Usuario() {
	}

	public Usuario(Integer id, String nome, String email, String senha, String poder, Integer id_area,
			Integer id_congregacao, Ugrupo ugrupo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.poder = poder;
		this.id_area = id_area;
		this.id_congregacao = id_congregacao;
		this.ugrupo = ugrupo;
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

	public Integer getId_area() {
		return id_area;
	}

	public void setId_area(Integer id_area) {
		this.id_area = id_area;
	}

	public Integer getId_congregacao() {
		return id_congregacao;
	}

	public void setId_congregacao(Integer id_congregacao) {
		this.id_congregacao = id_congregacao;
	}

	public Ugrupo getUgrupo() {
		return ugrupo;
	}

	public void setUgrupo(Ugrupo ugrupo) {
		this.ugrupo = ugrupo;
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
