package com.bosonit.dependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class PersonaServicesImp implements PersonaServices {

    Persona person = new Persona();

    public PersonaServicesImp()
    {
        //person.setNombre("");
       // person.setEdad("");
    }

    public String getNombre()
    {
        return person.getNombre();
    }

    public void setNombre(String nombre)
    {
        person.setNombre(nombre);
    }
}

