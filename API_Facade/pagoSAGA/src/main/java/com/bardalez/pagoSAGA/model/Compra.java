package com.bardalez.pagoSAGA.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Compra")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@ManyToOne
    @JoinColumn(name = "idcard")
	private Card card;
	
	@Column(name = "gasto")
	private Double gasto;
	
	@Column(name = "fecha")
	private Date fecha;

	public Compra() {}
	public Compra(Card card, Double gasto, Date fecha) {
		this.card = card;
		this.gasto = gasto;
		this.fecha = fecha;
	}

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Double getGasto() {
		return gasto;
	}
	public void setGasto(Double gasto) {
		this.gasto = gasto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	@Override
	public String toString() {
		return "Compra [Id=" + Id + ", gasto=" + gasto + ", fecha=" + fecha + "]";
	}	
}
