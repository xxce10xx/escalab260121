package com.bardalez.kafka.controller;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bardalez.kafka.models.Foo1;

@RestController
public class TxController {

	@Autowired
	private KafkaTemplate<String, Foo1> template;

	@PostMapping(path = "/send/foos/{what}")
	public void sendFoo(@PathVariable String what) {
		this.template.executeInTransaction(kafkaTemplate -> {
		  StringUtils.commaDelimitedListToSet(what).stream().map(s -> new Foo1(s)).forEach(foo -> {
				try {
					kafkaTemplate.send("topicTx", foo);
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		  return null;
		});
	}
	
	@Transactional
	@PostMapping(path = "/send/foos2/{what}")
	public void sendFoo2(@PathVariable String what) {
		template.send("topicTx", new Foo1(what));
	}
}
