package com.example.ej63.CRUDS.controller;

import com.example.ej63.CRUDS.model.Persons;
import com.example.ej63.CRUDS.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class createController {

    @Autowired
    PersonsService personsService;

    //creating post mapping that post the person detail in the database
    @PostMapping("/savePerson")
    private int savePerson(@RequestBody Persons persons)
    {
        personsService.saveOrUpdate(persons);
        return persons.getPersonId();
    }
}
