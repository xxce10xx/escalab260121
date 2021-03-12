package com.bardalez.composer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bardalez.composer.clients.ProductoFeignClient;
import com.bardalez.composer.models.Producto;

@Service
public class ProductoServiceImp implements ProductoService {
	
	@Autowired
	private ProductoFeignClient productoFeignClient;

	@Override
	public Optional<Producto> getProducto(Integer codigo) {
		return productoFeignClient.getProducto(codigo);
	}

}
