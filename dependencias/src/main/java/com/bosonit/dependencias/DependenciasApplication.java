package com.bosonit.dependencias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DependenciasApplication {

	public static void main(String[] args) {

		SpringApplication.run(DependenciasApplication.class, args);
	}

	@Bean
	PersonaServices getPersonaServices() {
		PersonaServices p=  new PersonaServicesImp();
		p.setNombre("el del bean");
		return p;
	}

}
