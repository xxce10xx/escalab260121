package com.bardalez.microeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroeurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroeurekaApplication.class, args);
	}

}
