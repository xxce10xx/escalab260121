package com.bardalez.productoSAGA.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.bardalez.productoSAGA.model.Producto;
import com.bardalez.productoSAGA.model.TXCompra;

public class EventConsumer {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RabbitListener(queues="rollbackProducto")
	public void receive(TXCompra txCompra) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("codigo").is(txCompra.getCodProd()));
		Update update = new Update();
		update.inc("unidades", txCompra.getUnidades());
		mongoTemplate.updateFirst(query, update, Producto.class);
	}

}
