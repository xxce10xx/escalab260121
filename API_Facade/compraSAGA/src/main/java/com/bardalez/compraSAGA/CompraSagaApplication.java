package com.bardalez.compraSAGA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CompraSagaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompraSagaApplication.class, args);
	}

}
