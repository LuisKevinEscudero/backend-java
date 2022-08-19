package com.bosonit.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class request {

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

    @GetMapping("user/{name}")
    //localhost:8080/kevin
    public String miName(@PathVariable String name)
    {
        return "Mi nombre es: " + name;
    }


    //esto en el postman es asi: localhost:8080/useradd
    /*
    el JSON:
    {
        "nombre":"kevin",
        "edad":25
     }
     */
    @PostMapping("{useradd}")
    public Person holaMundoPost(@RequestBody Person persona)
    {
        int edad1 = persona.getEdad()+1;
        persona.setComentario("Hola mundo post: " + persona.getNombre() + " edad -> " + persona.getEdad() + " edad + 1 -> " + edad1);
        return persona;
    }
}
