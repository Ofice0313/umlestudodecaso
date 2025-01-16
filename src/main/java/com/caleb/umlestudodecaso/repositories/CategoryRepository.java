package com.caleb.umlestudodecaso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caleb.umlestudodecaso.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	

}
