package com.caleb.umlestudodecaso.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Date moment;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="address_of_delivery_id")
	private Address addressOfDelivery;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemOrder> itens = new HashSet<>();
	public Pedido() {
		
	}

	public Pedido(Integer id, Date moment, Client client, Address addressOfDelivery) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		this.addressOfDelivery = addressOfDelivery;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getAddressOfDelivery() {
		return addressOfDelivery;
	}

	public void setAddressOfDelivery(Address addressOfDelivery) {
		this.addressOfDelivery = addressOfDelivery;
	}
	
	public Set<ItemOrder> getItens() {
		return itens;
	}

	public void setItens(Set<ItemOrder> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
}
