package com.bardalez.composer.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bardalez.composer.models.Producto;

@FeignClient(name = "producto-saga")
public interface ProductoFeignClient {

	@GetMapping("/producto/{codigo}")
	public Optional<Producto> getProducto(@PathVariable Integer codigo);
}
