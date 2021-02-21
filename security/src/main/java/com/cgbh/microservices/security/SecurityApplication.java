package com.cgbh.microservices.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@EnableEurekaClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "12345";
		
		for (int i = 0; i < 2; i++) {
			String passwordBCrypt = passwordEncode.encode(password);
			System.out.println(passwordBCrypt);
		}
		
		String passwordBCrypt = passwordEncode.encode("elsecreto");
		System.out.println(passwordBCrypt);
	}
}
