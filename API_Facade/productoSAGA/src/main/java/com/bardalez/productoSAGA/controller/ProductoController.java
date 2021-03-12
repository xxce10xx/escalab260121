package com.bardalez.productoSAGA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bardalez.productoSAGA.repository.ProductoRepository;
import com.bardalez.productoSAGA.model.Producto;
import com.bardalez.productoSAGA.model.TXCompra;
import com.bardalez.productoSAGA.producer.EventSenderMessage;


@RestController
public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private EventSenderMessage eventSenderMessage;
	
	@GetMapping("/productos")
	public List<Producto> getProductos()
	{
		List<Producto> productList = productoRepository.findAll();
		return productList;
	}
	
	@PostMapping("/producto")
	public Producto addProducto(@RequestBody Producto newProducto)
	{
		Producto prod = new Producto(newProducto.getCodigo(), newProducto.getNombre(), newProducto.getMarca(), newProducto.getUnidades(), newProducto.getPrecioUnitario(), newProducto.getDescripcion());
		productoRepository.insert(prod);
		return prod;
	}
	
	@PostMapping("/actualizarCatalogo")
	public String actualizarCatalogo(@RequestBody TXCompra txCompra)
	{
		Optional<Producto> tempProd = getProducto(txCompra.getCodProd());
		
		if(tempProd.isPresent()) {
			if(tempProd.get().getUnidades() >= txCompra.getUnidades()) {
				Query query = new Query();
				query.addCriteria(Criteria.where("codigo").is(txCompra.getCodProd()));
				Update update = new Update();
				update.set("unidades", tempProd.get().getUnidades() - txCompra.getUnidades());
				mongoTemplate.updateFirst(query, update, Producto.class);
				
				//mandar evento
				txCompra.setPrecioUnitario(tempProd.get().getPrecioUnitario());
				eventSenderMessage.sendMessage(txCompra);
				
			}else {
				return "No hay suficientes unidades";
			}
			
		}else {
			return "Error de codigo de producto";
		}
		return "Procesando su pedido ...";
	}
	
	@GetMapping("/producto/{codigo}")
	public Optional<Producto> getProducto(@PathVariable Integer codigo)
	{
		Optional<Producto> prod = productoRepository.findById(codigo);
		return prod;
	}
	
	

}
