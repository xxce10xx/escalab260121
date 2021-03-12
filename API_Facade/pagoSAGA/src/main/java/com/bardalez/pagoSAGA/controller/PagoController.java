package com.bardalez.pagoSAGA.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagoController {
	
	@GetMapping(value = "/okSAGA")
	public String getHealthCheck()
	{
		return "Transaccion finalizada con Exito";
	}
	
}
