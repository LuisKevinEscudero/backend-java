package com.example.ejer523;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador1 {

    @Autowired
    @Qualifier("Bean1")
    PersonaService personaService;

    @Autowired
    @Qualifier("Bean1")
    PersonaService personaService1;



    //@GetMapping("/controlador1/addPerson/{nombre}/{poblacion}/{edad}")
    @GetMapping("/controlador1/addPerson")
    public Persona addPerson(@RequestHeader String nombre, @RequestHeader String poblacion, @RequestHeader int edad)
    {
        return personaService.addPersona(new Persona().addPersona(nombre, poblacion, edad));
    }

    @PutMapping
    public Persona hola(@RequestBody Persona persona)
    {
        if (persona.getEdad() > 18)
        {
            personaService1.addPersona(persona);
        }
        else
        {
            personaService.addPersona(persona);
        }
        return  persona;
    }



}
