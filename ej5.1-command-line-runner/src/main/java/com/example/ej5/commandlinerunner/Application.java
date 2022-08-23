package com.example.ej5.commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	Commands commands = new Commands();

	public static void main(String[] args) {
		System.out.println("Iniciando aplicacion");
		SpringApplication.run(Application.class, args);
		//System.out.println("Aplicacion finalizada");
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("Estamos dentro del Runner");
		/*for (int i=0; i<5; i++)
		{
			System.out.println("Vuelta: "+i);
		}*/
		commands.initialClass1();
		commands.initialClass2();
		commands.initialClass3();
		commands.initialClass3Modifield("agua",3);
	}
}
