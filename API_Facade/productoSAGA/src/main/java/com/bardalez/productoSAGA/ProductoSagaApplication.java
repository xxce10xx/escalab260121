package com.bardalez.productoSAGA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductoSagaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductoSagaApplication.class, args);
	}

}
