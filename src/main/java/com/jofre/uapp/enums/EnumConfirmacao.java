package com.jofre.uapp.enums;

public enum EnumConfirmacao {
	
	SIM(1,"Sim"),
	NAO(2,"Não"),
	INDIFERENTE(3,"Indiferente");
	
	private int cod;
	private String descricao;
	
	private EnumConfirmacao() {
	}
	
	private EnumConfirmacao(int cod,String descricao) {
		this.cod =cod;
		this.descricao =descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public static EnumConfirmacao toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(EnumConfirmacao x: EnumConfirmacao.values()) {
			if(cod ==(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
}
