package com.bardalez.microproductos.controller;
/*
 * Aplicativo desarrollado para la clase de Java Expert
 * Autor: Cedric Bardalez
 * Version 1.0
 * www.cjavaperu.com
 */

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bardalez.microproductos.model.Producto;
import com.bardalez.microproductos.repository.ProductoRepository;

@RestController
@CrossOrigin(origins = "*")
public class ProductoController
{
	@Autowired
	ProductoRepository productoRepository;
	
	@Value("${server.port}")
	private String puerto;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@GetMapping(value = "/healthCatalogo", produces = "application/json; charset=utf-8")
	public String getHealthCheck()
	{
		return "{ \"todoOk\" : true }";
	}
	
	@RequestMapping("/")
	public String ribbonPing()
	{
		return "Ok";
	}

	@GetMapping("/productos")
	public List<Producto> getProductos()
	{
		List<Producto> productList = productoRepository.findAll();
		return productList;
	}
	
	@GetMapping("/actualizarCatalogo/{codigo}/{unidades}")
	public String actualizarCatalogo(@PathVariable String codigo, @PathVariable Integer unidades)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("codigo").is(codigo));
		Update update = new Update();
		update.set("unidades", unidades);
		mongoTemplate.updateFirst(query, update, Producto.class);
		return "ok";
	}

	@GetMapping("/producto/{codigo}")
	public Optional<Producto> getProducto(@PathVariable String codigo)
	{
		Optional<Producto> prod = productoRepository.findById(codigo);
		Producto prodTemp = prod.get();
		prodTemp.setPort(puerto);
		return prod;
	}
	
//	@GetMapping("/producto/{codigo}")
//	public ResponseEntity<Producto> getProducto(@PathVariable String codigo)
//	{
//		return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
//	}

	@PutMapping("/producto/{codigo}")
	public Optional<Producto> updateEmployee(@RequestBody Producto newProducto, @PathVariable String codigo)
	{
		Optional<Producto> optionalPro = productoRepository.findById(codigo);
		if (optionalPro.isPresent()) {
			Producto prod = optionalPro.get();
			prod.setNombre(newProducto.getNombre());
			prod.setMarca(newProducto.getMarca());
			prod.setUnidades(newProducto.getUnidades());
			prod.setPrecioUnitario(newProducto.getPrecioUnitario());
			prod.setDescripcion(newProducto.getDescripcion());
			productoRepository.save(prod);
		}
		return optionalPro;
	}

	@DeleteMapping(value = "/producto/{codigo}", produces = "application/json; charset=utf-8")
	public String deleteEmployee(@PathVariable String codigo) {
		Boolean result = productoRepository.existsById(codigo);
		productoRepository.deleteById(codigo);
		return "{ \"operacionExitosa\" : "+ (result ? "true" : "false") +" }";
	}

	@PostMapping("/producto")
	public Producto addEmployee(@RequestBody Producto newProducto)
	{
		Producto prod = new Producto(newProducto.getCodigo(), newProducto.getNombre(), newProducto.getMarca(), newProducto.getUnidades(), newProducto.getPrecioUnitario(), newProducto.getDescripcion());
		productoRepository.insert(prod);
		return prod;
	}
}
