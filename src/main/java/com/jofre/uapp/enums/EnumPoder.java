package com.jofre.uapp.enums;

public enum EnumPoder {
	ADMIN(1, "ROLE_ADMIN"),
	PASTOR(2,"ROLE_PASTOR"),
	SUPERVISOR(3,"ROLE_SUPERVISOR"),
	COORDENADOR(4, "ROLE_COORDENADOR"),
	LIDER(5,"ROLE_LIDER"),
	DIRECAO(6,"ROLE_DIRECAO"),
	SECRETARIA(7, "ROLE_SECRETARIA"),
	PROFESSOR(8,"ROLE_PROFESSOR"),
	LIDERADO(9, "ROLE_LIDERADO"),
	CONSULTA(10, "ROLE_CONSULTA");
	
	
	private int cod;
	private String descricao;
	
	private EnumPoder() {
	}
	
	private EnumPoder(int cod,String descricao) {
		this.cod =cod;
		this.descricao =descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public static EnumPoder toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(EnumPoder x: EnumPoder.values()) {
			if(cod ==(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}

}
