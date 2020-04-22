package com.jofre.uapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jofre.uapp.enums.EnumStatusCadastro;

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
	private boolean eMembro;
	private String fone;
	private String nomePai;
	private String fonePai;
	private String nomeMae;
	private String foneMae;
	private boolean paiMembro;
	private boolean maeMembro;
	private String endereco;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "congregacao_id")
	private Congregacao congregacao;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "tipopessoa_id")
	private TipoPessoa tipoPessoa;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "statuspessoa_id")
	private StatusPessoa statusPessoa;
	
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
	
	
	
	public Pessoa() {

	}

	public Pessoa(Integer id) {
		super();
		this.id = id;
	}
	public Pessoa(Integer id, EnumStatusCadastro ativo, String nome, boolean eMembro, Congregacao congregacao,
			TipoPessoa tipoPessoa, StatusPessoa statusPessoa, Profissao profissao) {
		super();
		this.id = id;
		this.ativo = ativo.getCod();
		this.nome = nome;
		this.eMembro = eMembro;
		this.congregacao = congregacao;
		this.tipoPessoa = tipoPessoa;
		this.statusPessoa = statusPessoa;
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
	
	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public StatusPessoa getStatusPessoa() {
		return statusPessoa;
	}

	public void setSpessoa(StatusPessoa statusPessoa) {
		this.statusPessoa = statusPessoa;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public String getNome() {
		return nome;
	}
	
	public EnumStatusCadastro getAtivo() {
		return EnumStatusCadastro.toEnum(ativo);
	}

	public void setAtivo(EnumStatusCadastro ativo) {
		this.ativo = ativo.getCod();
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
