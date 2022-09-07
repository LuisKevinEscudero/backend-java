package com.example.ej7.crudvalidation.controller;

import com.example.ej7.crudvalidation.model.Person;
import com.example.ej7.crudvalidation.service.PersonService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class updateController {

    @Autowired
    PersonService1 personService;

    @PutMapping("/updatePerson")
    private Person update(@RequestBody Person person) {
        personService.saveOrUpdate(person);
        return person;
    }
}
