package com.jofre.uapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jofre.uapp.domain.Congregacao;
import com.jofre.uapp.domain.Pessoa;
import com.jofre.uapp.domain.Profissao;
import com.jofre.uapp.enums.EnumConfirmacao;
import com.jofre.uapp.enums.EnumSituacaoPessoa;
import com.jofre.uapp.enums.EnumStatusCadastro;
import com.jofre.uapp.enums.EnumTipoPessoa;

public class PessoaDTO implements Serializable {
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
	private Profissao profissao;
	private Congregacao congregacao;
	private String area;
	public PessoaDTO(){
	}
	
	public PessoaDTO(Pessoa obj) {
		id = obj.getId();
		ativo = obj.getAtivo().getCod();
		nome = obj.getNome();
		nascimento = obj.getNascimento();
		eMembro = obj.iseMembro().getCod();
		tipoPessoa = obj.getTipoPessoa().getCod();
		situacaoPessoa = obj.getSituacaoPessoa().getCod();
		fone = obj.getFone();
		nomePai = obj.getNomePai();
		fonePai	= obj.getFonePai();
		nomeMae = obj.getNomeMae();
		foneMae = obj.getFoneMae();
		paiMembro = obj.isPaiMembro().getCod();
		maeMembro = obj.isMaeMembro().getCod();
		endereco = obj.getEndereco();
		profissao = obj.getProfissao();
		congregacao = obj.getCongregacao();
		area = obj.getCongregacao().getArea().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EnumStatusCadastro getAtivo() {
		return EnumStatusCadastro.toEnum(ativo);
	}

	public void setAtivo(EnumStatusCadastro ativo) {
		this.ativo = ativo.getCod();
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

	public EnumConfirmacao iseMembro() {
		return EnumConfirmacao.toEnum(eMembro);
	}

	public void seteMembro(EnumStatusCadastro eMembro) {
		this.eMembro = eMembro.getCod();
	}
	public EnumTipoPessoa getTipoPessoa() {
		return EnumTipoPessoa.toEnum(tipoPessoa);
	}

	public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa.getCod();
	}
	public EnumSituacaoPessoa getSituacaoPessoa() {
		return EnumSituacaoPessoa.toEnum(situacaoPessoa);
	}

	public void setSpessoa(EnumSituacaoPessoa situacaoPessoa) {
		this.situacaoPessoa = situacaoPessoa.getCod();
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

	public EnumConfirmacao isPaiMembro() {
		return EnumConfirmacao.toEnum(paiMembro);
	}

	public void setPaiMembro(EnumConfirmacao paiMembro) {
		this.paiMembro = paiMembro.getCod();
	}

	public EnumConfirmacao isMaeMembro() {
		return EnumConfirmacao.toEnum(maeMembro);
	}

	public void setMaeMembro(EnumConfirmacao maeMembro) {
		this.maeMembro = maeMembro.getCod();
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
