package com.caleb.umlestudodecaso.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ItemOrder implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemOrderPk id = new ItemOrderPk();
	
	private Double desconto;
	private Integer quantity;
	private Double price;
	
	
	public ItemOrder() {
		
	}

	public ItemOrder(Pedido pedido,Product product, Double desconto, Integer quantity, Double price) {
		super();
		id.setPedido(pedido);
		id.setProduct(product);
		this.desconto = desconto;
		this.quantity = quantity;
		this.price = price;
	}


	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public ItemOrderPk getId() {
		return id;
	}

	public void setId(ItemOrderPk id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		ItemOrder other = (ItemOrder) obj;
		return Objects.equals(id, other.id);
	}
	

}
