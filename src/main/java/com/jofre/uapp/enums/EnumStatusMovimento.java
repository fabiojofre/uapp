package com.jofre.uapp.enums;

public enum EnumStatusMovimento {
	PENDENTE(1,"Pendente"),
	LIBERADO(2,"Liberado"),
	CONCLUIDO(3,"Concluído"),
	CANCELADO(4, "Cancelado");
	
	private Integer cod;
	private String descricao;
	
	private EnumStatusMovimento() {
	}
	
	private EnumStatusMovimento(Integer cod,String descricao) {
		this.cod =cod;
		this.descricao =descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static EnumStatusMovimento toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(EnumStatusMovimento x: EnumStatusMovimento.values()) {
			if(cod ==(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
}
