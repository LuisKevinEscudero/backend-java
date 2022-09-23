package com.example.ej6.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Profile("perfil2")
@Component
public class perfil2 implements perfiles {

    @Override
    public void miFuncion()
    {
        System.out.println("Hola soy el perfil2");
    }



}
