package com.example.EjerDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador1 {

    @Autowired
    PersonaService personaService;



    //@GetMapping("/controlador1/addPerson/{nombre}/{poblacion}/{edad}")
    @GetMapping("/controlador1/addPerson")
    public Persona addPerson(@RequestHeader String nombre, @RequestHeader String poblacion, @RequestHeader int edad)
    {
        return personaService.addPersona(new Persona().addPersona(nombre, poblacion, edad));

        /*Persona p = new Persona();
        //p.addPersona(nombre, poblacion, edad);
        p.setNombre(nombre);
        p.setPoblacion(poblacion);
        p.setEdad(edad);
        return p;*/
        //return nombre + "" + poblacion + "" + edad;
    }

    @PutMapping
    public Persona getPersona()
    {
        return personaService.getPersona();
    }



}
