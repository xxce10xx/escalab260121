package com.bardalez.zprueba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PruebaController {
	
	@Value("${db.prueba}")
	private String pass;
	
	@GetMapping("/prueba")
	public String getPrueba() {
		return pass;
	}
}	
