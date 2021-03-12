package com.bardalez.compraSAGA.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bardalez.compraSAGA.model.Compra;
import com.bardalez.compraSAGA.model.CompraPK;

public interface CompraRepository extends JpaRepository<Compra,CompraPK>{

	@Query(value = "SELECT * FROM compra C WHERE C.cod_user = ?1", nativeQuery = true)
	public List<Compra> obtenerCompraUsuario(Integer codUser);
}
