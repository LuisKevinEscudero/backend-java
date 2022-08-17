package com.bosonit.dependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiControlador2 {

    @Autowired
    Persona PersonaServices;

    @GetMapping("/controlador2")
    String getControlador2() {
        return PersonaServices.getNombre();
    }
}
