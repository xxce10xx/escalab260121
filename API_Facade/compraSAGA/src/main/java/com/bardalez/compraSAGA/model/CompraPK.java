package com.bardalez.compraSAGA.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class CompraPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer codUser;
	private Integer codProd;
	private Date fecha;
	
	public CompraPK() {}
	public CompraPK(Integer codUser, Integer codProd, Date fecha) {
		super();
		this.codUser = codUser;
		this.codProd = codProd;
		this.fecha = fecha;
	}
	
	public Integer getCodUser() {
		return codUser;
	}
	public void setCodUser(Integer codUser) {
		this.codUser = codUser;
	}
	public Integer getCodProd() {
		return codProd;
	}
	public void setCodProd(Integer codProd) {
		this.codProd = codProd;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProd == null) ? 0 : codProd.hashCode());
		result = prime * result + ((codUser == null) ? 0 : codUser.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompraPK other = (CompraPK) obj;
		if (codProd == null) {
			if (other.codProd != null)
				return false;
		} else if (!codProd.equals(other.codProd))
			return false;
		if (codUser == null) {
			if (other.codUser != null)
				return false;
		} else if (!codUser.equals(other.codUser))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}
}
