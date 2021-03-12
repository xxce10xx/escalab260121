package com.bardalez.composer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@RibbonClients({@RibbonClient(name = "producto-saga"), @RibbonClient(name = "compra-saga")})
public class ComposerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComposerApplication.class, args);
	}

}
