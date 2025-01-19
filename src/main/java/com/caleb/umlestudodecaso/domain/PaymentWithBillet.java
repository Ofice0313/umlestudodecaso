package com.caleb.umlestudodecaso.domain;

import java.util.Date;

import com.caleb.umlestudodecaso.domain.enums.StatePayment;

import jakarta.persistence.Entity;

@Entity
public class PaymentWithBillet extends Payment{
	
	private static final long serialVersionUID = 1L;
	
	private Date dateSalary;
	private Date datePayment;
	
	public PaymentWithBillet() {
		
	}
	
	public PaymentWithBillet(Integer id, StatePayment state, Pedido order, Date dateSalary, Date datePayment) {
		super(id, state, order);
		this.dateSalary = dateSalary;
		this.datePayment = datePayment;	
	}

	public Date getDateSalary() {
		return dateSalary;
	}

	public void setDateSalary(Date dateSalary) {
		this.dateSalary = dateSalary;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

}
