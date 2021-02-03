package com.bardalez.microcesta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Cesta")
public class Cesta {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
	
	 @Column(name = "usario")
	 private String username;
	 
	 @Column(name = "producto")
	 private String nombreProducto;
	 
	 @Column(name = "marca")
	 private String marca;
	 
	 @Column(name = "pre_uni")
	 private Double precioUnitario;
	 
	 @Column(name = "unidades")
	 private Integer unidades;
	 
	 @Column(name = "prec_tot")
	 private Double precioTotal;
 
	public Cesta(){}

	public Cesta(String username, String nombreProducto, String marca, Double precioUnitario, Integer unidades,
			Double precioTotal) {
		super();
		this.username = username;
		this.nombreProducto = nombreProducto;
		this.marca = marca;
		this.precioUnitario = precioUnitario;
		this.unidades = unidades;
		this.precioTotal = precioTotal;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
}
