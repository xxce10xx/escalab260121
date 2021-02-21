package com.bardalez.webclient.config;

import java.util.Arrays;
import java.util.List;
import reactor.core.publisher.Flux;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SayHelloConfiguration {

	@Bean
	@Primary
	ServiceInstanceListSupplier serviceInstanceListSupplier() {
		return new DemoServiceInstanceListSuppler("servicio-catalogo");
	}
}

class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {

	private final String serviceId;

	DemoServiceInstanceListSuppler(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public String getServiceId() {
		return serviceId;
	}

	@Override
	public Flux<List<ServiceInstance>> get() {
		return Flux.just(Arrays
				.asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8080, false),
						new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8081, false)));
	}
}

