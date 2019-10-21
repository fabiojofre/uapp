package com.jofre.uapp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private boolean ativo = false;
	private String nome;
	private Date nascimento;
	private boolean eMembro = false ;
	private String fone;
	private String nomePai;
	private String fonePai;
	private String nomeMae;
	private String foneMae;
	private boolean paiMembro;
	private boolean maeMembro;
	private String endereco;

	@ManyToOne
	@JoinColumn(name = "congregacao_id")
	private Congregacao congregacao;

	@ManyToOne
	@JoinColumn(name = "tipo_pessoa_id")
	private TipoPessoa tipoPessoa;
	
	public Pessoa() {

	}

	public Pessoa(Integer id) {
		super();
		this.id = id;
	}

	public Pessoa(Integer id, boolean ativo, Congregacao congregacao, TipoPessoa tipoPessoa, String nome, Date nascimento, boolean eMembro, String fone,
			String nomePai, String fonePai, String nomeMae, String foneMae, boolean paiMembro, boolean maeMembro,
			String endereco) {
		super();
		this.id = id;
		this.ativo = ativo;
		this.congregacao = congregacao;
		this.tipoPessoa = tipoPessoa;
		this.nome = nome;
		this.nascimento = nascimento;
		this.eMembro = eMembro;
		this.fone = fone;
		this.nomePai = nomePai;
		this.fonePai = fonePai;
		this.nomeMae = nomeMae;
		this.foneMae = foneMae;
		this.paiMembro = paiMembro;
		this.maeMembro = maeMembro;
		this.endereco = endereco;
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

	public String getNome() {
		return nome;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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
