package com.bardalez.compraSAGA.model;

import java.util.Date;

public class TXCompra {
	private Integer codProd;
	private Integer codUser;
	private String codCard;
	private Integer unidades;
	private Double precioUnitario;
	private Date date;
	
	public TXCompra() {}
	public TXCompra(Integer codProd, Integer codUser, String codCard, Integer unidades) {
		super();
		this.codProd = codProd;
		this.codUser = codUser;
		this.codCard = codCard;
		this.unidades = unidades;
	}
	
	public Integer getCodProd() {
		return codProd;
	}
	public void setCodProd(Integer codProd) {
		this.codProd = codProd;
	}
	public Integer getCodUser() {
		return codUser;
	}
	public void setCodUser(Integer codUser) {
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
