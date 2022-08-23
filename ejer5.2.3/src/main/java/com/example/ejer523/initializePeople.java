package com.example.ejer523;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class initializePeople {

    @Bean
    public Persona bean1()
    {
        return  new Persona("bean1","",0);
    }

    @Bean
    public Persona bean2()
    {
        return  new Persona("bean2","",0);
    }

    @Bean
    public Persona bean3()
    {
        return  new Persona("bean3","",0);
    }
}
