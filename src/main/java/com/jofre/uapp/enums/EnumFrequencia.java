package com.jofre.uapp.enums;

public enum EnumFrequencia {
	
	PRESENTE(1,"Presente"),
	AUSENTE(2,"Ausente"),
	JUSTIFICADO(3,"Justificado");
	
	private int cod;
	private String descricao;
	
	private EnumFrequencia() {
	}
	
	private EnumFrequencia(int cod,String descricao) {
		this.cod =cod;
		this.descricao =descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public static EnumFrequencia toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(EnumFrequencia x: EnumFrequencia.values()) {
			if(cod ==(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
}
