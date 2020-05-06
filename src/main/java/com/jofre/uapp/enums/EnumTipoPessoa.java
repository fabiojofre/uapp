package com.jofre.uapp.enums;

public enum EnumTipoPessoa {
	ADULTO(1, "Adulto"),
	JOVEM(2,"Jovem"),
	ADOLESCENTE(3,"Adolescente");
	
	
	private int cod;
	private String descricao;
	
	private EnumTipoPessoa() {
	}
	
	private EnumTipoPessoa(int cod,String descricao) {
		this.cod =cod;
		this.descricao =descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public static EnumTipoPessoa toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(EnumTipoPessoa x: EnumTipoPessoa.values()) {
			if(cod ==(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}

}
