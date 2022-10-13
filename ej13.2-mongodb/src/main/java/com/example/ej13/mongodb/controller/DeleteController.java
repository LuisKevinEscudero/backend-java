package com.example.ej13.mongodb.controller;

import com.example.ej13.mongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @Autowired
    private PersonRepository personRepository;

    @DeleteMapping("/deletePerson/{idPerson}")
    public void deletePerson(Integer idPerson)
    {
        personRepository.deleteById(idPerson);
    }
}
