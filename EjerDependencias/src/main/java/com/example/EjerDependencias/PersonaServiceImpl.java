package com.example.EjerDependencias;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
    Persona persona = new Persona();
    @Override
    public Persona addPersona(Persona p) {
        persona = p;
        return persona;
    }

    @Override
    public Persona getPersona() {
        return persona;
    }

}
