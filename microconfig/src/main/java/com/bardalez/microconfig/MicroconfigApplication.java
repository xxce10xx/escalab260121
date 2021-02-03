package com.bardalez.microconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroconfigApplication.class, args);
	}

}
