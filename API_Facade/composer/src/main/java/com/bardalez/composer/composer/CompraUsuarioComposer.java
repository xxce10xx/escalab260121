package com.bardalez.composer.composer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bardalez.composer.models.Compra;
import com.bardalez.composer.models.CompraUsuario;
import com.bardalez.composer.models.Producto;
import com.bardalez.composer.service.CompraService;
import com.bardalez.composer.service.ProductoService;

@Component
public class CompraUsuarioComposer {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CompraService compraService;
	
	public List<CompraUsuario> parserCompraUsuario(Integer codUser) {
		List<Compra> compraList = compraService.obtenerCompra(codUser);
		List<CompraUsuario> compraUsuarioList = new ArrayList<CompraUsuario>();
		
		for(Compra compra : compraList) {
			CompraUsuario compraUsuarioTemp = new CompraUsuario();
			compraUsuarioTemp.setFecha(compra.getCodCompra().getFecha());
			compraUsuarioTemp.setCantidad(compra.getCantidad());
		
			Producto productoTemp = productoService.getProducto(compra.getCodCompra().getCodProd()).get();
			
			compraUsuarioTemp.setProducto(productoTemp);
			
			compraUsuarioList.add(compraUsuarioTemp);
		}
		
		return compraUsuarioList;
	}
}
