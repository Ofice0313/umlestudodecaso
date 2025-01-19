package com.caleb.umlestudodecaso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caleb.umlestudodecaso.domain.Address;
import com.caleb.umlestudodecaso.domain.Category;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	

}
