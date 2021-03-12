package com.bardalez.pagoSAGA.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Card")
public class Card {
	
	@Id
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "salOri")
	private Double saldoOriginal;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "card")
	private List<Compra> compras;

	public Card() {}
	public Card(String codigo, Double saldoOriginal) {
		this.codigo = codigo;
		this.saldoOriginal = saldoOriginal;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Double getSaldoOriginal() {
		return saldoOriginal;
	}
	public void setSaldoOriginal(Double saldoOriginal) {
		this.saldoOriginal = saldoOriginal;
	}
	public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	@Override
	public String toString() {
		return "Card [codigo=" + codigo + ", saldoOriginal=" + saldoOriginal + ", compra=" + compras + "]";
	}
}
