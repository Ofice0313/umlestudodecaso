package com.caleb.umlestudodecaso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caleb.umlestudodecaso.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}
