package com.sinqia.teste_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteApiApplication {
	public static void main(String[] args) {
		// Em 1 linha de código subo o SpringBoot
		// Aqui já tenho um Tomcat embarcado
		SpringApplication.run(TesteApiApplication.class, args);
	}
}