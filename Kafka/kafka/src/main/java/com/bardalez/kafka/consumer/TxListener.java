package com.bardalez.kafka.consumer;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.bardalez.kafka.models.Foo1;

/*@Component
public class TxListener {
	
	private final Logger logger = LoggerFactory.getLogger(TxListener.class);
	
	@Autowired
	private KafkaTemplate<String, String> template;

	@KafkaListener(topics = "topic_2", groupId = "fooGroup2")
	public void listen(List<Foo1> foos) throws IOException {
		logger.info("Received_2: " + foos);
		foos.forEach(f -> template.send("topic_3", f.getMsj().toUpperCase()));
		logger.info("Messages sent, hit enter to commit tx");
		//System.in.read();
	}

	@KafkaListener(groupId = "fooGroup3", topics = "topic_3")
	public void listen(String in) {
		logger.info("Received_3: " + in);
	}
}*/
