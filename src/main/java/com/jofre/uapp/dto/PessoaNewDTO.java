package com.jofre.uapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PessoaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer ativo;
	private String nome;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	private Integer eMembro;
	private Integer tipoPessoa;
	private Integer situacaoPessoa;
	private String fone;
	private String nomePai;
	private String fonePai;
	private String nomeMae;
	private String foneMae;
	private Integer paiMembro;
	private Integer maeMembro;
	private String endereco;
	private Integer profissaoId;
	private Integer congregacaoId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAtivo() {
		return ativo;
	}
	public void setAtivo(Integer ativo) {
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
	public Integer geteMembro() {
		return eMembro;
	}
	public void seteMembro(Integer eMembro) {
		this.eMembro = eMembro;
	}
	public Integer getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(Integer tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public Integer getSituacaoPessoa() {
		return situacaoPessoa;
	}
	public void setSituacaoPessoa(Integer situacaoPessoa) {
		this.situacaoPessoa = situacaoPessoa;
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
	public Integer getPaiMembro() {
		return paiMembro;
	}
	public void setPaiMembro(Integer paiMembro) {
		this.paiMembro = paiMembro;
	}
	public Integer getMaeMembro() {
		return maeMembro;
	}
	public void setMaeMembro(Integer maeMembro) {
		this.maeMembro = maeMembro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getProfissaoId() {
		return profissaoId;
	}
	public void setProfissaoId(Integer profissaoId) {
		this.profissaoId = profissaoId;
	}
	public Integer getCongregacaoId() {
		return congregacaoId;
	}
	public void setCongregacaoId(Integer congregacaoId) {
		this.congregacaoId = congregacaoId;
	}
	

	
}
