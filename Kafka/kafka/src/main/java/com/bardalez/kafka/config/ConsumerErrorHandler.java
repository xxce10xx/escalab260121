package com.bardalez.kafka.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.errors.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.serializer.Deserializer;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.converter.Jackson2JavaTypeMapper.TypePrecedence;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import com.bardalez.kafka.consumer.Listener;
import com.bardalez.kafka.models.Bar;
import com.bardalez.kafka.models.Foo1;
import com.bardalez.kafka.models.Foo2;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
@Configuration
@EnableKafka
public class ConsumerErrorHandler {
	
	private final Logger logger = LoggerFactory.getLogger(Listener.class);
	
	@Bean
	protected JsonDeserializer<List<Foo1>> kafkaDeserializer() {
	    ObjectMapper om = new ObjectMapper();
	    JavaType type = om.getTypeFactory().constructParametricType(List.class, Foo1.class);
	    return new JsonDeserializer<List<Foo1>>(type, om, false);
	}
	*/
	
	
	
	/*@Bean
	public RecordMessageConverter converter() {
	  return new StringJsonMessageConverter();
	}*/
	
	/*@Bean
	public RecordMessageConverter converter() {
	  StringJsonMessageConverter converter = new StringJsonMessageConverter();
	  DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
	  typeMapper.setTypePrecedence(TypePrecedence.TYPE_ID);
	  typeMapper.addTrustedPackages("com.common");
	  Map<String, Class<?>> mappings = new HashMap<>();
	  mappings.put("foo", Foo2.class);
	  mappings.put("bar", Bar.class);
	  typeMapper.setIdClassMapping(mappings);
	  converter.setTypeMapper(typeMapper);
	  return converter;
	}*/


	/*@Bean
	public ConcurrentKafkaListenerContainerFactory<Object, Object> kafkaListenerContainerFactory(
			ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
			ConsumerFactory<Object, Object> kafkaConsumerFactory) {

		ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
		configurer.configure(factory, kafkaConsumerFactory);
		factory.setErrorHandler(new SeekToCurrentErrorHandler()); // <<<<<

		/*factory.setRetryTemplate(retryTemplate());
		factory.setRecoveryCallback((context -> {

            if(context.getLastThrowable().getCause() instanceof RecoverableDataAccessException){

                //here you can do your recovery mechanism where you can put back on to the topic using a Kafka producer

            } else{
                // here you can log things and throw some custom exception that Error handler will take care of ..
                throw new RuntimeException(context.getLastThrowable().getMessage());
            }
            return null;

        }));
		
		factory.setErrorHandler(((exception, data) -> {            
			/* here you can do you custom handling, I am just logging it same as default Error handler does
			 * If you just want to log. you need not configure the error handler here. The default handler does it for you.
			 * Generally, you will persist the failed records to DB for tracking the failed records.  
			 */
	/*
			logger.error("Error in process with Exception {} and the record is {}", exception, data);        
			})); */
		
	//	return factory;
	//}

//	private RetryTemplate retryTemplate() {
//
//		RetryTemplate retryTemplate = new RetryTemplate();
//		/*
//		 * here retry policy is used to set the number of attempts to retry and what
//		 * exceptions you wanted to try and what you don't want to retry.
//		 */
//		
//		retryTemplate.setRetryPolicy(getSimpleRetryPolicy());
//		return retryTemplate;
//	}
//
//	private SimpleRetryPolicy getSimpleRetryPolicy() {
//		Map<Class<? extends Throwable>, Boolean> exceptionMap = new HashMap<>();// the boolean value in the map
//		exceptionMap.put(TimeoutException.class, true);							// determines whether exception should
//																				// be retried
//																				// exceptionMap.put(IllegalArgumentException.class,
//																				// false);
//	
//		return new SimpleRetryPolicy(3, exceptionMap, true);
//	}

//}
