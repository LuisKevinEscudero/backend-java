package com.example.ej13.mongodb.controller;

import com.example.ej13.mongodb.model.Person;
import com.example.ej13.mongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Person getPersonById(@PathVariable Integer idPerson) {
        Optional<Person> person = Optional.of(personRepository.findById(idPerson).get());
        return person.orElse(null);
    }
    /*public Optional<Person> getPersonById(Integer idPerson) {
        return personRepository.findById(idPerson);
    }*/
}
