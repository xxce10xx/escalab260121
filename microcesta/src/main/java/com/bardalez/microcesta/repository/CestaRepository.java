package com.bardalez.microcesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bardalez.microcesta.model.Cesta;

public interface CestaRepository extends JpaRepository<Cesta,Integer>{

}
