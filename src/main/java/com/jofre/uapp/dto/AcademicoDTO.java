package com.jofre.uapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jofre.uapp.domain.Academico;
import com.jofre.uapp.enums.EnumStatusMovimento;

public class AcademicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String observacao;
	private Integer status;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataFim;
	
	private int tipoacademicoId;
	
	
	public AcademicoDTO() {
	}
	public AcademicoDTO(Academico obj) {
		id = obj.getId();
		observacao = obj.getObservacao();
		status = obj.getStatus().getCod();
		dataInicio = obj.getDataInicio();
		dataFim = obj.getDataFim();
		tipoacademicoId = obj.getTipoAcademico().getId();
		
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
	public int getTipoAcademicoId() {
		return tipoacademicoId;
	}
	public void setTipoAcademicoId(int tipoacademicoId) {
		this.tipoacademicoId = tipoacademicoId;
	}
	
	
}
