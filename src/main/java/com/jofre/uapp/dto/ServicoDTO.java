package com.jofre.uapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jofre.uapp.domain.Servico;
import com.jofre.uapp.domain.TipoServico;
import com.jofre.uapp.enums.EnumStatusMovimento;

public class ServicoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String observacao;
	private Integer status;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	private String desc1;
	private String desc2;
	private int tiposervico;
	
	public ServicoDTO() {
	}
	public ServicoDTO(Servico obj) {
		id = obj.getId();
		observacao = obj.getObservacao();
		status = obj.getStatus().getCod();
		data = obj.getData();
		desc1 = obj.getTipoServico().getDesc1();
		desc2 = obj.getTipoServico().getDesc2();
		tiposervico = obj.getTipoServico().getId();
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
	public String getDesc1() {
		return desc1;
	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	public String getDesc2() {
		return desc2;
	}
	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}
	public TipoServico getTiposervico() {
		return TipoServico.class.cast(tiposervico);
	}
	public void setTiposervico(TipoServico tiposervico) {
		this.tiposervico = tiposervico.getId();
	}

	
	
}
