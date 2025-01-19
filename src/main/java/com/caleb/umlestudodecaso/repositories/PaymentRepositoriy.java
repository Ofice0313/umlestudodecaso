package com.caleb.umlestudodecaso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caleb.umlestudodecaso.domain.Payment;

@Repository
public interface PaymentRepositoriy extends JpaRepository<Payment, Integer>{

}
