package com.bardalez.kafka.models;

import java.io.Serializable;

public class Bar implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String msj;
	
	public Bar() {}
	
	public Bar(String msj) {
		this.msj = msj;
	}
	public String getMsj() {
		return msj;
	}
	public void setMsj(String msj) {
		this.msj = msj;
	}
	
	@Override
	public String toString() {
		return "Bar [msj=" + msj + "]";
	}
}
