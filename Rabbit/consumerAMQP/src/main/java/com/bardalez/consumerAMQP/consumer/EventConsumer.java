package com.bardalez.consumerAMQP.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.bardalez.consumerAMQP.model.Employee;

public class EventConsumer {
	
	@RabbitListener(queues="employee.created")
	public void receive(Employee employee) {
	    System.out.println(employee.getLastName());
	}
}
