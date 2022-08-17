package com.bosonit.dependencias;

import org.springframework.stereotype.Component;

@Component
public class Persona {
    String edad;
    String nombre;

    public String getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addPersona(String nombre, String poblacion, int edad)
    {
        this.nombre = nombre;
        this.edad = Integer.toString(edad);
    }
}
