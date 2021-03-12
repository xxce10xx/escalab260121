package com.bardalez.kafka.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bardalez.kafka.models.Bar;
import com.bardalez.kafka.models.Foo1;

/*@RestController
public class Controller2 {

	@Autowired
	private KafkaTemplate<Object, Object> template;

	@PostMapping(path = "/send/foo/{what}")
	public void sendFoo(@PathVariable String what) {
		this.template.send(new GenericMessage<>(new Foo1(what),
				Collections.singletonMap(KafkaHeaders.TOPIC, "foos")));
	}

	@PostMapping(path = "/send/bar/{what}")
	public void sendBar(@PathVariable String what) {
		this.template.send(new GenericMessage<>(new Bar(what),
				Collections.singletonMap(KafkaHeaders.TOPIC, "bars")));
	}

	@PostMapping(path = "/send/unknown/{what}")
	public void sendUnknown(@PathVariable String what) {
		this.template.send(new GenericMessage<>(what,
				Collections.singletonMap(KafkaHeaders.TOPIC, "bars")));
	}
}*/
