package com.caleb.umlestudodecaso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caleb.umlestudodecaso.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
