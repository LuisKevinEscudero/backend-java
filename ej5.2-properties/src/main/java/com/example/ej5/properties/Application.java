package com.example.ej5.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Value("${greeting}")
	private String greeting;

	@Value("${my.number}")
	private int number;

	@Autowired
	private Environment environment;
	//@Value("${new.property:new.property no tiene valor}")
	private String property;



	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("el valor de greeting es: "+greeting);
		System.out.println("el valor de my.number es: "+number);

		this.property = environment.getProperty("new.property");
		System.out.println("el valor de new.property es: "+property);
	}
}
