package com.bardalez.microproductos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bardalez.microproductos.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {

}
