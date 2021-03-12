package com.bardalez.kafka.consumer;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.bardalez.kafka.models.Bar;
import com.bardalez.kafka.models.Foo1;

/*@Component
@KafkaListener(id = "multiGroup", topics = { "foos", "bars" })
public class MultiMethods {

	@KafkaHandler
	public void foo(Foo1 foo) {
		System.out.println("Received: " + foo);
	}

	@KafkaHandler
	public void bar(Bar bar) {
		System.out.println("Received: " + bar);
	}

	@KafkaHandler(isDefault = true)
	public void unknown(Object object) {
		System.out.println("Received unknown: " + object);
	}

}*/
