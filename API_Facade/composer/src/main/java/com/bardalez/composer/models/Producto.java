package com.bardalez.composer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Producto {

	private Integer codigo;
	private String nombre;
	private String marca;
	private Integer unidades;
	private Double precioUnitario;
	private String descripcion;

}