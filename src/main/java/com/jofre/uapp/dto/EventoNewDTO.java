package com.jofre.uapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jofre.uapp.domain.Evento;
import com.jofre.uapp.domain.TipoEvento;
import com.jofre.uapp.enums.EnumStatusMovimento;

public class EventoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String observacao;
	private Integer status;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	private int tipoeventoId;
	
	public EventoNewDTO(){
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

	public EnumStatusMovimento getStatus() {
		return EnumStatusMovimento.toEnum(status);
	}
	
	public void setStatus(EnumStatusMovimento status) {
		this.status = status.getCod();
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	public int getTipoeventoId() {
		return tipoeventoId;
	}
	public void setTipoevento(int tipoeventoId) {
		this.tipoeventoId = tipoeventoId;
	}
	
}
