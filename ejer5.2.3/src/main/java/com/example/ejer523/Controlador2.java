package com.example.ejer523;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {
    @Autowired
    PersonaService personaService;

    @GetMapping("/controlador2/getPersona")
    public Persona getPersona()
    {
        personaService.getPersona().setEdad(personaService.getPersona().getEdad() * 2);
        return personaService.getPersona();
    }

}
