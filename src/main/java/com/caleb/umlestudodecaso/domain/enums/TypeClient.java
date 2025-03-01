package com.caleb.umlestudodecaso.domain.enums;

public enum TypeClient {
	
	NATURAL_PERSON(1, "Natural Person"),
	LEGAL_ENTITY(2, "Legal Entity");
	
	private int cod;
	private String description;
	
	private TypeClient(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static TypeClient toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TypeClient x: TypeClient.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid Id: " + cod);
	}
}
