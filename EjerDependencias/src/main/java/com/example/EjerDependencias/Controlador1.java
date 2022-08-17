package com.example.EjerDependencias;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {

    @GetMapping("/controlador1/addPerson/{nombre}/{poblacion}/{edad}")
    public String addPerson(@PathVariable String nombre, @PathVariable String poblacion, @PathVariable int edad)
    {
        Persona p = new Persona();
        p.addPersona(nombre, poblacion, edad);
        //return p;
        return nombre + "" + poblacion + "" + edad;
    }



}
