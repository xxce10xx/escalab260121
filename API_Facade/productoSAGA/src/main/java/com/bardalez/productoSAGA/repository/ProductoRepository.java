package com.bardalez.productoSAGA.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bardalez.productoSAGA.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, Integer> {

}
