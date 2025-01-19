package com.caleb.umlestudodecaso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caleb.umlestudodecaso.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
