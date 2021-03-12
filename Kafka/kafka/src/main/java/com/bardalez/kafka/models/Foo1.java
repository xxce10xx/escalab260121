package com.bardalez.kafka.models;

import java.io.Serializable;

public class Foo1 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String msj;
	
	public Foo1() {}
	
	public Foo1(String msj) {
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
		return "Foo1 [msj=" + msj + "]";
	}
}
