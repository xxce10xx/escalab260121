package com.bardalez.pagoSAGA.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bardalez.pagoSAGA.producer.EventSenderMessage;


@Configuration
public class EventProducerConfiguration {
	
	public static final String EXCHANGE = "exchange-saga-rollback";

	@Bean
	TopicExchange topicExchange() {
	      return new TopicExchange(EXCHANGE);
	}
	
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    
    @Bean
	public AmqpTemplate rabbitTemp(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}
    
    @Bean 
    public EventSenderMessage eventSenderMessage() {
    	return new EventSenderMessage();
    } 
}
