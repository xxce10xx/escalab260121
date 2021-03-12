package com.bardalez.composer.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bardalez.composer.models.Compra;

@FeignClient(name = "compra-saga")
public interface CompraFeignClient {
	
	@GetMapping("/compra/usuario/{codUser}")
	public List<Compra> getCompraUsuario(@PathVariable Integer codUser);
}
