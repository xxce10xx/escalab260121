package com.bardalez.webclient.controller;

import reactor.core.publisher.Mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@RestController
public class UserApplication {

	private final WebClient.Builder loadBalancedWebClientBuilder;
	private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

	public UserApplication(WebClient.Builder webClientBuilder, ReactorLoadBalancerExchangeFilterFunction lbFunction) {
		this.loadBalancedWebClientBuilder = webClientBuilder;
		this.lbFunction = lbFunction;
	}

	@RequestMapping("/prod")
	public Mono<String> hi(@RequestParam(value = "codigo", defaultValue = "1") String codigo) {
		return loadBalancedWebClientBuilder.build().get().uri("http://servicio-catalogo/producto/".concat(codigo)).retrieve()
				.bodyToMono(String.class);
	}

	@RequestMapping("/prod2")
	public Mono<String> hello(@RequestParam(value = "codigo", defaultValue = "1") String codigo) {
		return WebClient.builder().filter(lbFunction).build().get().uri("http://servicio-catalogo/producto/".concat(codigo)).retrieve()
				.bodyToMono(String.class);
	}
}
