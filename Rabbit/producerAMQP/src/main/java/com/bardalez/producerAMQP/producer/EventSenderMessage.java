package com.bardalez.producerAMQP.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.bardalez.producerAMQP.model.Employee;


public class EventSenderMessage {
	
	@Autowired
	private AmqpTemplate rabbitTemp;
	
	@Autowired
	private TopicExchange topicExchange;
	
	public EventSenderMessage() {}
	
	public void sendMessage(Employee employee) {
		rabbitTemp.convertAndSend(topicExchange.getName(),"employee.created", employee);
	}
}
