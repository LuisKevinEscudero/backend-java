package com.example.ejer523;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Qualifier("bean1")
	@Bean
	public PersonaService persona1()
	{
		PersonaService p = new PersonaServiceImpl();
		p.addPersona(new Persona().addPersona("Bean1","",0));
		return p;
	}

	@Qualifier("bean2")
	@Bean
	public PersonaService persona2()
	{
		PersonaService p = new PersonaServiceImpl();
		p.addPersona(new Persona().addPersona("Bean2","",0));
		return p;
	}

	@Qualifier("bean3")
	@Bean
	public PersonaService persona3()
	{
		PersonaService p = new PersonaServiceImpl();
		p.addPersona(new Persona().addPersona("Bean3","",0));
		return p;
	}

}
