package com.bardalez.kafka.producer.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bardalez.kafka.producer.model.User;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate2;

    public void sendMessage(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
    
    public void sendMessage(User user) {
        logger.info(String.format("#### -> Producing message -> %s", user.getName()));
        this.kafkaTemplate2.send("objeto_user1", user);
    }
}