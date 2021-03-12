package com.bardalez.composer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bardalez.composer.clients.CompraFeignClient;
import com.bardalez.composer.models.Compra;

@Service
public class CompraServiceImp implements CompraService {
	
	@Autowired
	private CompraFeignClient compraFeignClient;

	@Override
	public List<Compra> obtenerCompra(Integer codUser) {
		return compraFeignClient.getCompraUsuario(codUser);
	}
}
