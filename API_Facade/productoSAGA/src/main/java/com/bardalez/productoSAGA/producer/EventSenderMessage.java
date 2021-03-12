package com.bardalez.productoSAGA.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.bardalez.productoSAGA.model.TXCompra;


public class EventSenderMessage {
	
	@Autowired
	private AmqpTemplate rabbitTemp;
	
	@Autowired
	private DirectExchange directExchange;
	
	public EventSenderMessage() {}
	
	public void sendMessage(TXCompra txCompra) {
		rabbitTemp.convertAndSend(directExchange.getName(),"saga.compra", txCompra);
	}
}
