package com.bardalez.listener.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

/*
@Configuration
public class ConsumerConfig {

	@Bean
	public RecordMessageConverter converter() {
	  StringJsonMessageConverter converter = new StringJsonMessageConverter();
	  DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
	  typeMapper.setTypePrecedence(typeMapper.getTypePrecedence());
	  Map<String, Class<?>> mappings = new HashMap<>();
	  mappings.put("foo", Foo1.class);
	  mappings.put("foos", List.class);
	  typeMapper.setIdClassMapping(mappings);
	  converter.setTypeMapper(typeMapper);
	  return converter;
	}
}
*/