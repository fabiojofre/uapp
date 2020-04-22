package com.jofre.uapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jofre.uapp.domain.Pessoa;

public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String ativo;
	private String nome;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	private boolean eMembro;
	private String fone;
	private String nomePai;
	private String fonePai;
	private String nomeMae;
	private String foneMae;
	private boolean paiMembro;
	private boolean maeMembro;
	private String endereco;
	private String profissao;
	private String congregacao;
	private String area;
	public PessoaDTO(){
	}
	
	public PessoaDTO(Pessoa obj) {
		id = obj.getId();
		ativo = obj.getAtivo().getDescricao();
		nome = obj.getNome();
		nascimento = obj.getNascimento();
		eMembro = obj.iseMembro();
		fone = obj.getFone();
		nomePai = obj.getNomePai();
		fonePai	= obj.getFonePai();
		nomeMae = obj.getNomeMae();
		foneMae = obj.getFoneMae();
		paiMembro = obj.isPaiMembro();
		maeMembro = obj.isMaeMembro();
		endereco = obj.getEndereco();
		profissao = obj.getProfissao().getProfissao();
		congregacao = obj.getCongregacao().getNome();
		area = obj.getCongregacao().getArea().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public boolean iseMembro() {
		return eMembro;
	}

	public void seteMembro(boolean eMembro) {
		this.eMembro = eMembro;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getFonePai() {
		return fonePai;
	}

	public void setFonePai(String fonePai) {
		this.fonePai = fonePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getFoneMae() {
		return foneMae;
	}

	public void setFoneMae(String foneMae) {
		this.foneMae = foneMae;
	}

	public boolean isPaiMembro() {
		return paiMembro;
	}

	public void setPaiMembro(boolean paiMembro) {
		this.paiMembro = paiMembro;
	}

	public boolean isMaeMembro() {
		return maeMembro;
	}

	public void setMaeMembro(boolean maeMembro) {
		this.maeMembro = maeMembro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(String congregacao) {
		this.congregacao = congregacao;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	

}
