package com.caleb.umlestudodecaso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caleb.umlestudodecaso.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

}
