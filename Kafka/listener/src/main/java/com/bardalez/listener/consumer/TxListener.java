package com.bardalez.listener.consumer;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bardalez.kafka.models.Foo1;


@Component
public class TxListener {
	
	private final Logger logger = LoggerFactory.getLogger(TxListener.class);
	
	@Autowired
	private KafkaTemplate<String, String> template;

	@KafkaListener(topics = "topicTx", groupId = "groupTx")
	public void listen(List<Foo1> foos) throws IOException {
		logger.info("Received_2: " + foos);
		//foos.forEach(f -> template.send("topicTx", f.getMsj().toUpperCase()));
		logger.info("Messages sent, hit enter to commit tx");
		//System.in.read();
	}

	/*@KafkaListener(groupId = "groupTx", topics = "topicTx")
	public void listen(String in) {
		logger.info("Received_3: " + in);
	}*/
}
