package com.bardalez.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.bardalez.kafka.models.Foo2;

public class Listener {

	private final Logger logger = LoggerFactory.getLogger(Listener.class);

	/*@KafkaListener(id = "fooGroup", topics = "topic1")
	public void listen(String in) {
		logger.info("Received: " + in);
		if (in.startsWith("foo")) {
			throw new RuntimeException("failed");
		}
	}

	@KafkaListener(id = "dltGroup", topics = "topic1.DLT")
	public void dltListen(String in) {
		logger.info("Received from DLT: " + in);
	}*/
	
	/*KafkaListener(id = "fooGroup", topics = "topic1")
	public void listen(Foo2 foo) {
	  logger.info("Received: " + foo);
	  if (foo.getMsj().startsWith("fail")) {
	    throw new RuntimeException("failed");
	  }
	}

	@KafkaListener(id = "dltGroup", topics = "topic1.DLT")
	public void dltListen(Foo2 in) {
	  logger.info("Received from DLT: " + in);
	}*/
}
