package com.jofre.uapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jofre.uapp.domain.Evento;
import com.jofre.uapp.enums.EnumStatusMovimento;

public class EventoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String observacao;
	private Integer status;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	private int tipoeventoId;
	
	public EventoDTO(){
	}
	
	public EventoDTO(Evento obj) {
		id = obj.getId();
		observacao = obj.getObservacao();
		status = obj.getStatus().getCod();
		data = obj.getData();
		tipoeventoId =obj.getTipoEvento().getId();
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
