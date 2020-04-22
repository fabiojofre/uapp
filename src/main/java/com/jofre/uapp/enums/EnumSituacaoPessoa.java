package com.jofre.uapp.enums;

public enum EnumSituacaoPessoa {
	
	COMUNHAO(1,"Comunhão"),
	AFASTADO(2,"Afastado"),
	DISCIPLINADO(3,"Disciplinado"),
	DESVIADO(4,"Desviado"),
	CONGREGADO(5,"Congregado");
	
	private int cod;
	private String descricao;
	
	private EnumSituacaoPessoa() {
	}
	
	private EnumSituacaoPessoa(int cod,String descricao) {
		this.cod =cod;
		this.descricao =descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public static EnumSituacaoPessoa toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(EnumSituacaoPessoa x: EnumSituacaoPessoa.values()) {
			if(cod ==(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
}
