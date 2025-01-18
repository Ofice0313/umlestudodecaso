package com.caleb.umlestudodecaso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caleb.umlestudodecaso.domain.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
