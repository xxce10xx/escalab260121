package com.bardalez.kafka.producer.consumer;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.bardalez.kafka.producer.model.User;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    /*@KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }*/
    
    @KafkaListener(topics = "objeto_user1", groupId = "mi_grupo")
    public void consume(User user) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", user.getName()));
    }
}