package com.bardalez.productoSAGA.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

import com.bardalez.productoSAGA.consumer.EventConsumer;



@Configuration
public class EventConsumerConfiguration implements RabbitListenerConfigurer {
	
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("exchange-saga-rollback");
	}

	@Bean
	public Queue queueRollback() {
		return new Queue("rollbackProducto");
	}
	
	@Bean
	public Binding bindingRollback(Queue queueRollback, TopicExchange topicExchange) {
		return BindingBuilder.bind(queueRollback).to(topicExchange).with("rollback.*");
	}
	
	@Bean
	public EventConsumer eventConsumer() {
		return new EventConsumer();
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	}
	
	@Bean
    MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());
        return messageHandlerMethodFactory;
    }
	
	@Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }
}
