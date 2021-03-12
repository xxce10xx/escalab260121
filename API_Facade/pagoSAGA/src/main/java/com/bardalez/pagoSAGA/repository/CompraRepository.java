package com.bardalez.pagoSAGA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bardalez.pagoSAGA.model.*;

public interface CompraRepository extends JpaRepository<Compra,Integer> {
	
}
