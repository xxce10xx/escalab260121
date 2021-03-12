package com.bardalez.kafka2;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class Kafka2Application {

	public static void main(String[] args) {
		SpringApplication.run(Kafka2Application.class, args);
	}

	@Bean
	public Supplier<Flux<Long>> producer() {
		return () -> Flux.interval(Duration.ofSeconds(1)).log();

	}

	@Bean
	public Function<Flux<Long>, Flux<Long>> processor() {
		return longFlux -> longFlux.map(i -> i * i).log();
	}

	@Bean
	public Consumer<Long> consumer() {
		return (i) -> {
			System.out.println("Consumer Received : " + i);
		};
	}
}
