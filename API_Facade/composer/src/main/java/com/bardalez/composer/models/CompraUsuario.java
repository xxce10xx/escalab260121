package com.bardalez.composer.models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraUsuario {
	private Producto producto;
	private Date fecha;
	private Integer cantidad;
}
