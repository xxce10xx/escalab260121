package com.bardalez.composer.service;

import java.util.List;
import com.bardalez.composer.models.Compra;

public interface CompraService {
	
	List<Compra> obtenerCompra(Integer codUser);
}
