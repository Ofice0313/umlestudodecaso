package com.caleb.umlestudodecaso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caleb.umlestudodecaso.domain.State;

public interface StateRepository extends JpaRepository<State, Integer>{

}
