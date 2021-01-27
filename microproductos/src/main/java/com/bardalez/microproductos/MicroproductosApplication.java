package com.bardalez.microproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroproductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroproductosApplication.class, args);
	}

}
