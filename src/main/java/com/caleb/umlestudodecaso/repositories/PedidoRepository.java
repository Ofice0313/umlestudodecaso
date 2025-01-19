package com.caleb.umlestudodecaso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caleb.umlestudodecaso.domain.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	

}
