package com.caleb.umlestudodecaso.domain.enums;

public enum StatePayment {
	
	PENDENT(1, "PENDENT"),//PENDENTE
	CANCELLED(2, "CENCELLED"),
	PAID_OFF(3, "PAID_OFF");//QUITADO
	
	private int cod;
	private String description;
	
	private StatePayment(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static StatePayment toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(StatePayment x: StatePayment.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid Id: " + cod);
	}

}
