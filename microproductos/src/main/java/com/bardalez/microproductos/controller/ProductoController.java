package com.bardalez.microproductos.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import com.bardalez.microproductos.model.Producto;
import com.bardalez.microproductos.service.ProductoService;

@RestController
@CrossOrigin(origins = "*")
public class ProductoController
{
	@Autowired
	ProductoService productoService;

	@GetMapping(value = "/healthCatalogo", produces = "application/json; charset=utf-8")
	public String getHealthCheck()
	{
		return "{ \"todoOk\" : true }";
	}

	@GetMapping("/productos")
	public List<Producto> getProductos()
	{
		return productoService.listaProductros();
	}
	
	@GetMapping("/actualizarCatalogo/{codigo}/{unidades}")
	public String actualizarCatalogo(@PathVariable String codigo, @PathVariable Integer unidades)
	{
		return productoService.actualizarCatalogo(codigo, unidades);
	}

	@GetMapping("/producto/{codigo}")
	public Optional<Producto> getProducto(@PathVariable String codigo)
	{
		return productoService.obtenerProducto(codigo);
	}

	@PutMapping("/producto/{codigo}")
	public Optional<Producto> updateProducto(@RequestBody Producto producto, @PathVariable String codigo)
	{
		return productoService.actualizarProducto(producto, codigo);
	}

	@DeleteMapping(value = "/producto/{codigo}")
	public HttpEntity<String> deleteProducto(@PathVariable String codigo) {
		String resultado = productoService.eliminarProducto(codigo);
		return new HttpEntity<String>(resultado);
	}

	@PostMapping("/producto")
	public Producto addProducto(@RequestBody Producto producto)
	{
		return productoService.guardarProducto(producto);
	}
}
