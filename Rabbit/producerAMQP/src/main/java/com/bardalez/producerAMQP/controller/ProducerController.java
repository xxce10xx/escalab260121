package com.bardalez.producerAMQP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bardalez.producerAMQP.model.Employee;
import com.bardalez.producerAMQP.producer.EventSenderMessage;

@RestController
public class ProducerController {
	
	@Autowired
	EventSenderMessage eventSenderMessage;
	
	@GetMapping("/send")
	public String sendMessage()
	{
		Employee tempEmployee = new Employee();
		tempEmployee.setFirstName("Carlos");
		tempEmployee.setLastName("Trauco");
		tempEmployee.setAge(25);
		eventSenderMessage.sendMessage(tempEmployee);
		
		return "ok";
	}
	
}
