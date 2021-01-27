package com.bardalez.microproductos.service;

import java.util.List;
import java.util.Optional;
import com.bardalez.microproductos.model.Producto;

public interface ProductoService {
	Producto guardarProducto(Producto producto);
	String eliminarProducto(String codigo);
	Optional<Producto> actualizarProducto(Producto producto, String codigo);
	Optional<Producto> obtenerProducto(String codigo);
	List<Producto> listaProductros();
	String actualizarCatalogo(String codigo, Integer unidades);
}
