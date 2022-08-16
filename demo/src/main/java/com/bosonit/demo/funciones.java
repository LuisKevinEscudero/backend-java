package com.bosonit.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class funciones {

    @GetMapping("{name}")
    //localhost:8080/kevin
    public String holaMundo(@PathVariable String name)
    {
        return "Hola mundo: " + name;
    }

    @GetMapping
    //localhost:8080/kevin
    public String holaMundoSimple()
    {
        return "Hola mundo simple";
    }

    @PostMapping("{useradd}")
    //esto en el postman es asi: localhost:8080/useradd
    /*
    el JSON:
    {
        "nombre":"kevin",
        "edad":25
     }
     */
    public Persona holaMundoPost(@RequestBody Persona persona)
    {
        int edad1 = persona.getEdad()+1;
        persona.setComentario("Hola mundo post: " + persona.getNombre() + " edad -> " + persona.getEdad() + " edad + 1 -> " + edad1);
        return persona;
    }
}
