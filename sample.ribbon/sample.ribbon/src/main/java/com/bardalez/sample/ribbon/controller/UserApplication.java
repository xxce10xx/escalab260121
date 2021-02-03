package com.bardalez.sample.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bardalez.sample.ribbon.config.SayHelloConfiguration;

@RestController
@RibbonClient(name = "servicio-catalogo", configuration = SayHelloConfiguration.class)
public class UserApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/prod")
	public String hi(@RequestParam(value = "codigo", defaultValue = "1") String codigo) {
		String prodTemp = this.restTemplate.getForObject("http://servicio-catalogo/producto/"+codigo, String.class);
		return prodTemp;
	}

}