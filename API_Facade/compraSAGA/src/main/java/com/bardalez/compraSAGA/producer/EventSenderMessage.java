package com.bardalez.compraSAGA.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.bardalez.compraSAGA.model.TXCompra;

public class EventSenderMessage {
	
	@Autowired
	private AmqpTemplate rabbitTemp;
	
	@Autowired
	private DirectExchange directExchange;
	
	@Autowired
	private TopicExchange topicExchange;
	
	public EventSenderMessage() {}
	
	public void sendMessage(TXCompra txCompra) {
		rabbitTemp.convertAndSend(directExchange.getName(),"saga.pago", txCompra);
	}
	
	public void sendMessageRollback(TXCompra txCompra) {
		rabbitTemp.convertAndSend(topicExchange.getName(),"rollback.producto", txCompra);
	}
}
