package com.bardalez.composer.service;

import java.util.Optional;
import com.bardalez.composer.models.Producto;

public interface ProductoService {
	
	Optional<Producto> getProducto(Integer codigo);
}
