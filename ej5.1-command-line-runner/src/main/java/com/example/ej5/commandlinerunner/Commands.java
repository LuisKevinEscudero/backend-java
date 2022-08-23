package com.example.ej5.commandlinerunner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

public class Commands {

    @PostConstruct
    public void initialClass1()
    {
        System.out.println("Hola desde la clase inicial");
    }

    @Bean
    CommandLineRunner initialClass2()
    {
        System.out.println("Hola desde la clase secundaria");
        return null;

    }

    @Bean
    CommandLineRunner initialClass3()
    {
        System.out.println("Soy la tercera clase");
        return null;
    }

    //@Bean
    CommandLineRunner initialClass3Modifield(String param1, int param2)
    {
        System.out.println("primer parametro: "+ param1 + " , segundo parametro : "+param2);
        return null;
    }


}
