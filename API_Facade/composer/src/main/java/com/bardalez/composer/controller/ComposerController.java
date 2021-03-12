package com.bardalez.composer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bardalez.composer.composer.CompraUsuarioComposer;
import com.bardalez.composer.models.CompraUsuario;

@RestController
public class ComposerController {

	@Autowired
	private CompraUsuarioComposer compraUsuarioComposer;
	
	@GetMapping("/compra/usuario/{codigo}")
	public List<CompraUsuario> getCompraUsuario(@PathVariable Integer codigo){
		return compraUsuarioComposer.parserCompraUsuario(codigo);
	}
}
