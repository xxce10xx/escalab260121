package com.bardalez.microcesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import com.bardalez.microcesta.config.RibbonConfigurator;


@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "restTemplate", configuration = {RibbonConfigurator.class})
@EnableCircuitBreaker
public class MicrocestaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrocestaApplication.class, args);
	}

}
