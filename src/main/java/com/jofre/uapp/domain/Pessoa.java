package com.jofre.uapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jofre.uapp.enums.EnumConfirmacao;
import com.jofre.uapp.enums.EnumSituacaoPessoa;
import com.jofre.uapp.enums.EnumStatusCadastro;
import com.jofre.uapp.enums.EnumTipoPessoa;

@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer ativo;
	private String nome;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	private Integer eMembro;
	private String fone;
	private String nomePai;
	private String fonePai;
	private String nomeMae;
	private String foneMae;
	private Integer paiMembro;
	private Integer maeMembro;
	private String endereco;
	private Integer tipoPessoa;
	private Integer situacaoPessoa;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "congregacao_id")
	private Congregacao congregacao;
		
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "profissao_id")
	private Profissao profissao;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.pessoaS")
	private Set<FrequenciaServico> frequenciaS = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.pessoaE")
	private Set<FrequenciaEvento> frequenciaE = new HashSet<>();
	
	@ElementCollection
	@CollectionTable(name="caracteristicas")
	private Set<String> caracteristicas = new HashSet<>();
	
	@ElementCollection
	@CollectionTable(name="desafios")
	private Set<String> desafios = new HashSet<>();
	
	public Pessoa() {
	}

	public Pessoa(Integer id) {
		super();
		this.id = id;
	}


	public Pessoa(Integer id, EnumStatusCadastro ativo, String nome, Date nascimento, EnumConfirmacao eMembro, String fone, String nomePai,
			String fonePai, String nomeMae, String foneMae, EnumConfirmacao paiMembro, EnumConfirmacao maeMembro, String endereco,
			EnumTipoPessoa tipoPessoa, EnumSituacaoPessoa situacaoPessoa, Congregacao congregacao, Profissao profissao) {
		super();
		this.id = id;
		this.ativo = ativo.getCod();
		this.nome = nome;
		this.nascimento = nascimento;
		this.eMembro = eMembro.getCod();
		this.fone = fone;
		this.nomePai = nomePai;
		this.fonePai = fonePai;
		this.nomeMae = nomeMae;
		this.foneMae = foneMae;
		this.paiMembro = paiMembro.getCod();
		this.maeMembro = maeMembro.getCod();
		this.endereco = endereco;
		this.tipoPessoa = tipoPessoa.getCod();
		this.situacaoPessoa = situacaoPessoa.getCod();
		this.congregacao = congregacao;
		this.profissao = profissao;
	}

	@JsonIgnore
	public List<Servico>getServicos(){
		List<Servico> lista = new ArrayList<>();
		for(FrequenciaServico x: frequenciaS) {
			lista.add(x.getServico());
		}
		return lista;
	}
	
	@JsonIgnore
	public List<Evento>getEventos(){
		List<Evento> lista = new ArrayList<>();
		for(FrequenciaEvento x: frequenciaE) {
			lista.add(x.getEvento());
		}
		return lista;
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
	
	public EnumConfirmacao geteMembro() {
		return EnumConfirmacao.toEnum(eMembro);
	}

	public void seteMembro(EnumConfirmacao eMembro) {
		this.eMembro = eMembro.getCod();
	}
	
	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
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

	public void setSituacaoPessoa(EnumSituacaoPessoa situacaoPessoa) {
		this.situacaoPessoa = situacaoPessoa.getCod();
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}



	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
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

	public EnumConfirmacao getPaiMembro() {
		return EnumConfirmacao.toEnum(paiMembro);
	}

	public void setPaiMembro(EnumConfirmacao paiMembro) {
		this.paiMembro = paiMembro.getCod();
	}

	public EnumConfirmacao getMaeMembro() {
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
	
	
	public Set<FrequenciaServico> getFrequenciaS() {
		return frequenciaS;
	}

	public void setFrequenciaS(Set<FrequenciaServico> frequenciaS) {
		this.frequenciaS = frequenciaS;
	}
	
	public Set<FrequenciaEvento> getFrequenciaE() {
		return frequenciaE;
	}

	public void setFrequenciaE(Set<FrequenciaEvento> frequenciaE) {
		this.frequenciaE = frequenciaE;
	}
	


	public Set<String> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(Set<String> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
