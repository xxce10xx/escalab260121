package com.bardalez.microproductos.config;
/*
 * Aplicativo desarrollado para la clase de Java Expert
 * Autor: Cedric Bardalez (CJava Perú)
 * Version 1.0
 * www.cjavaperu.com
 */


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.MongoClient;


@Configuration
@EnableMongoRepositories(basePackages="com.bardalez.microproductos.repository")
public class MongoConfig extends AbstractMongoConfiguration {
  
    //@Value("${server.mongo}")
    //private String mongoURI;
	
	
	@Override
    protected String getDatabaseName() {
        return "carritoMicro";
    }
  
    @Bean
    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }
}