package com.example.ej13.mongodb.controller;

import com.example.ej13.mongodb.repository.PersonRepository;
import com.example.ej13.mongodb.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @Autowired
    private PersonServiceImp personServiceImp;

    @DeleteMapping("/deletePerson/{idPerson}")
    public void deletePerson(@PathVariable Integer idPerson)
    {
        personServiceImp.deletePerson(idPerson);
    }
}
