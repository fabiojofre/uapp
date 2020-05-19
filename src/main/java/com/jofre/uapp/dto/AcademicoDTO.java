package com.jofre.uapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jofre.uapp.domain.Academico;
import com.jofre.uapp.domain.TipoAcademico;
import com.jofre.uapp.enums.EnumStatusMovimento;

public class AcademicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String observacao;
	private Integer status;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;
	private Date dataFim;
	
	private TipoAcademico tipoAcademico;
	
	
	public AcademicoDTO() {
	}
	public AcademicoDTO(Academico obj) {
		id = obj.getId();
		observacao = obj.getObservacao();
		status = obj.getStatus().getCod();
		dataInicio = obj.getDataInicio();
		dataFim = obj.getDataFim();
		tipoAcademico = obj.getTipoAcademico();
		
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
	public TipoAcademico getTipoAcademico() {
		return tipoAcademico;
	}
	public void setTipoAcademico(TipoAcademico tipoAcademico) {
		this.tipoAcademico = tipoAcademico;
	}
	
	
}
