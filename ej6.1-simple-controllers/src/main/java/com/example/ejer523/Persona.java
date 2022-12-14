package com.example.ejer523;

import org.springframework.stereotype.Component;

@Component
public class Persona {
    String nombre;
    String poblacion;
    int edad;

    public Persona ()
    {
    }

    public Persona(String nombre, String poblacion, int edad)
    {
        setNombre(nombre);
        setPoblacion(poblacion);
        setEdad(edad);
    }
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



}
