package com.bosonit.dependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiControlador {

    //@Autowired
    PersonaServices PersonaServices;

    public MiControlador(PersonaServices PersonaServices) {
        this.PersonaServices = PersonaServices;
    }

    @GetMapping
    public String getHolaMundo() {
        return "Hola mundo";
    }

    @GetMapping("/adios")
    public String dimeAdios() {
        return "Adios mundo";
    }

    @GetMapping("/nombre/{nombre}")
    public String dimeTuNombre(@PathVariable String nombre, @RequestParam (required=false, defaultValue="25") String edad)
    {
        PersonaServices.setNombre(nombre);
        return "Hola " + nombre + " tu edad es " + edad;
    }

     @GetMapping("/nombre/{nombre}/{apellidos}")
    public String xx(@PathVariable String nombre, @PathVariable("apellidos") String jj )
     {
         return "Hola " + nombre + " con apellido " + jj;
     }
}
