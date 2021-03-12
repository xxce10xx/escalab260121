package com.bardalez.composer.models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompraPK {	
	
	private Integer codUser;
	private Integer codProd;
	private Date fecha;
}
