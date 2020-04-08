package com.jofre.uapp.domain.mov;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Evento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String evento;
	
	private boolean ativo;
	private Date data;
	
	public Evento(){
		
	}

	public Evento(Integer id, String evento, boolean ativo, Date data) {
		super();
		this.id = id;
		this.evento = evento;
		this.ativo = ativo;
		this.data = data;
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public boolean isRepetitivo() {
		return ativo;
	}

	public void setRepetitivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getInicio() {
		return data;
	}

	public void setInicio(Date inicio) {
		this.data = inicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
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
		Evento other = (Evento) obj;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		return true;
	}
	
}
