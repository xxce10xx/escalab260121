package com.bardalez.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bardalez.kafka.producer.model.User;
import com.bardalez.kafka.producer.publisher.Producer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }
    
    @GetMapping(value = "/publish/{name}/{age}")
    public void sendMessageToKafkaTopic2(@PathVariable String name, @PathVariable int age) {
    	User miUser = new User(name, age);
        this.producer.sendMessage(miUser);
    }
}
