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
}
