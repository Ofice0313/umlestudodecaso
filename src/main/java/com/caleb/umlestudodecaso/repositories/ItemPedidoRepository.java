package com.caleb.umlestudodecaso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caleb.umlestudodecaso.domain.ItemOrder;
import com.caleb.umlestudodecaso.domain.ItemOrderPk;

public interface ItemPedidoRepository extends JpaRepository<ItemOrder, ItemOrderPk>{

}
