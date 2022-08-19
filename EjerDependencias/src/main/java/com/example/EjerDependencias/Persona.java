package com.example.EjerDependencias;

import org.springframework.stereotype.Component;

@Component
public class Persona {
    String nombre;
    String poblacion;
    int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public Persona addPersona(String nombre, String poblacion, int edad) {
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setPoblacion(poblacion);
        persona.setEdad(edad);

        return persona;
    }
}
