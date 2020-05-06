package com.jofre.uapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jofre.uapp.domain.Academico;

public class AcademicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String observacao;
	private String status;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;
	private Date dataFim;
	
	
	public AcademicoDTO() {
	}
	public AcademicoDTO(Academico obj) {
		id = obj.getId();
		observacao = obj.getObservacao();
		status = obj.getStatus().getDescricao();
		dataInicio = obj.getDataInicio();
		dataFim = obj.getDataFim();
		
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
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
}
