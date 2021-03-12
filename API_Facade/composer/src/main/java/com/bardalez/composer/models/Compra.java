package com.bardalez.composer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Compra{
	
	private CompraPK codCompra;
	private Integer cantidad;
	private Double precioUnitario;
}
