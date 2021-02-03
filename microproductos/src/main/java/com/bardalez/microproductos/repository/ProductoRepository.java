package com.bardalez.microproductos.repository;
/*
 * Aplicativo desarrollado para la clase de Java Expert
 * Autor: Cedric Bardalez (CJava Perú)
 * Version 1.0
 * www.cjavaperu.com
 */

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bardalez.microproductos.model.Producto;


public interface ProductoRepository extends MongoRepository<Producto, String> {

}
