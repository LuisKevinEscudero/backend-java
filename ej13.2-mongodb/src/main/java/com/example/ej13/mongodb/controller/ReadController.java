package com.example.ej13.mongodb.controller;

import com.example.ej13.mongodb.model.Person;
import com.example.ej13.mongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ReadController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/readAll")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/readPerson/{idPerson}")
    public Person getPersonById(Integer idPerson) {
        Optional<Person> person = personRepository.findById(idPerson);
        return person.orElse(null);
    }
}
