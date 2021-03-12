package com.bardalez.pagoSAGA.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.bardalez.pagoSAGA.model.TXCompra;

public class EventSenderMessage {
	
	@Autowired
	private AmqpTemplate rabbitTemp;
	
	@Autowired
	private TopicExchange topicExchange;
	
	public EventSenderMessage() {}
	
	public void sendMessage(TXCompra txCompra) {
		rabbitTemp.convertAndSend(topicExchange.getName(),"rollback.compra", txCompra);
	}
}
