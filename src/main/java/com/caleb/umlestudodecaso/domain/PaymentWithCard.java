package com.caleb.umlestudodecaso.domain;

import com.caleb.umlestudodecaso.domain.enums.StatePayment;

import jakarta.persistence.Entity;

@Entity
public class PaymentWithCard extends Payment{
	
	private static final long serialVersionUID = 1L;
	
	private Integer numberOfInstalments;
	
	public PaymentWithCard() {
		
	}

	public PaymentWithCard(Integer id, StatePayment state, Pedido order, Integer numberOfInstalments) {
		super(id, state, order);
		this.numberOfInstalments = numberOfInstalments;
	}

	public Integer getNumberOfInstalments() {
		return numberOfInstalments;
	}

	public void setNumberOfInstalments(Integer numberOfInstalments) {
		this.numberOfInstalments = numberOfInstalments;
	}

}
