package com.bardalez.microproductos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.bardalez.microproductos.model.Producto;
import com.bardalez.microproductos.repository.ProductoRepository;

@Service
public class ProductoServiceImp implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public Producto guardarProducto(Producto producto) {
		return productoRepository.insert(producto);
	}

	@Override
	public String eliminarProducto(String codigo) {
		if(codigo != null) {
			Boolean result = productoRepository.existsById(codigo);
			if(result) {
				productoRepository.deleteById(codigo);
				return "Eliminado exitosamente";
			}
			return "Código no valido";
		}
		return "Proporcione un código";	
	}

	@Override
	public Optional<Producto> actualizarProducto(Producto producto, String codigo) {
		Optional<Producto> optionalPro = productoRepository.findById(codigo);
		if (optionalPro.isPresent()) {
			Producto prod = optionalPro.get();
			prod.setNombre(producto.getNombre());
			prod.setMarca(producto.getMarca());
			prod.setUnidades(producto.getUnidades());
			prod.setPrecioUnitario(producto.getPrecioUnitario());
			prod.setDescripcion(producto.getDescripcion());
			productoRepository.save(prod);
		}
		return optionalPro;
	}

	@Override
	public Optional<Producto> obtenerProducto(String codigo) {
		Optional<Producto> prod = productoRepository.findById(codigo);
		return prod;
	}

	@Override
	public List<Producto> listaProductros() {
		List<Producto> productList = productoRepository.findAll();
		return productList;
	}

	@Override
	public String actualizarCatalogo(String codigo, Integer unidades) {
		Query query = new Query();
		query.addCriteria(Criteria.where("codigo").is(codigo));
		Update update = new Update();
		update.set("unidades", unidades);
		mongoTemplate.updateFirst(query, update, Producto.class);
		return "ok";
	}
}
