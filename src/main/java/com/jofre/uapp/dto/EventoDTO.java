package com.jofre.uapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jofre.uapp.domain.Evento;

public class EventoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String observacao;
	private String status;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	public EventoDTO(){
	}
	
	public EventoDTO(Evento obj) {
		id = obj.getId();
		observacao = obj.getObservacao();
		status = obj.getStatus().getDescricao();
		data = obj.getData();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
