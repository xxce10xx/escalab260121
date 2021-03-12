package com.bardalez.compraSAGA.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Compra")
//@IdClass(value = CompraPK.class)
public class Compra implements Serializable {
	
	/*@Id
	private String codUser;
	@Id
	private String codProd; */
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CompraPK compraPK;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "precio")
	private Double precioUnitario;

	public Compra() {}
	public Compra(CompraPK codCompra, Integer cantidad, Double precioUnitario) {
		super();
		this.compraPK = codCompra;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public CompraPK getCodCompra() {
		return compraPK;
	}

	public void setCodCompra(CompraPK codCompra) {
		this.compraPK = codCompra;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
}
