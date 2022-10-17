package com.example.ej13.mongodb.controller;

import com.example.ej13.mongodb.model.Person;
import com.example.ej13.mongodb.repository.PersonRepository;
import com.example.ej13.mongodb.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ReadController {

    @Autowired
    private PersonServiceImp personServiceImp;

    @GetMapping("/readAll")
    public List<Person> getAllPersons() {
        return personServiceImp.getAllPersons();
    }

    @GetMapping("/readById/{idPerson}")
    public Person getPersonById(@PathVariable Integer idPerson) {
        return personServiceImp.getPersonById(idPerson);
    }
}
