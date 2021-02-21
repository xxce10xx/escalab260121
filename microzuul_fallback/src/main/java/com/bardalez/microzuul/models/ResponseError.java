package com.bardalez.microzuul.models;

import java.io.Serializable;

public class ResponseError implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	private int codigo;
	private String status;
	
	public ResponseError(String mensaje, int codigo, String status) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
		this.status = status;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
