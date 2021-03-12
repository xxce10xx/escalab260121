package com.bardalez.compraSAGA.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bardalez.compraSAGA.model.Compra;
import com.bardalez.compraSAGA.repository.CompraRepository;

@RestController
public class CompraController {
	
	@Autowired
	CompraRepository compraRepository;
	
	@GetMapping("/compra/usuario/{codUser}")
	public List<Compra> getCompraUsuario(@PathVariable Integer codUser) {
		return compraRepository.obtenerCompraUsuario(codUser);
	}

}
