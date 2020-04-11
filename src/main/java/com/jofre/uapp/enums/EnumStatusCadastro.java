package com.jofre.uapp.enums;

public enum EnumStatusCadastro {
	ATIVO(1,"Ativo"),
	INATIVO(2,"Inativo");
	
	private Integer cod;
	private String descricao;
	
	private EnumStatusCadastro() {
	}
	
	private EnumStatusCadastro(Integer cod,String descricao) {
		this.cod =cod;
		this.descricao =descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public static EnumStatusCadastro toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(EnumStatusCadastro x: EnumStatusCadastro.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
}
