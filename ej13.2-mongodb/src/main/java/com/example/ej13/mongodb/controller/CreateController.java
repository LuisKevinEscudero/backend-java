package com.example.ej13.mongodb.controller;

import com.example.ej13.mongodb.model.Person;
import com.example.ej13.mongodb.repository.PersonRepository;
import com.example.ej13.mongodb.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateController {

//    @Autowired
//    private PersonRepository personRepository;
//
//    @PostMapping("/createPerson")
//    public Person createPerson(@RequestBody Person person) {
//        return personRepository.save(person);
//    }
    @Autowired
    private PersonServiceImp personServiceImp;

    @PostMapping("/createPerson")
    public Person createPerson(@RequestBody Person person) {
        personServiceImp.createPerson(person);
        return person;
    }
}
