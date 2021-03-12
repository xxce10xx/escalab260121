package com.bardalez.pagoSAGA.model;

import java.util.Date;

public class TXCompra {
	private String codProd;
	private String codUser;
	private String codCard;
	private Integer unidades;
	private Double precioUnitario;
	private Date date;
	
	public TXCompra() {}
	public TXCompra(String codProd, String codUser, String codCard, Integer unidades) {
		super();
		this.codProd = codProd;
		this.codUser = codUser;
		this.codCard = codCard;
		this.unidades = unidades;
	}
	
	public String getCodProd() {
		return codProd;
	}
	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}
	public String getCodUser() {
		return codUser;
	}
	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}
	public String getCodCard() {
		return codCard;
	}
	public void setCodCard(String codCard) {
		this.codCard = codCard;
	}
	public Integer getUnidades() {
		return unidades;
	}
	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
