package com.example.ej63.CRUDS.controller;

import com.example.ej63.CRUDS.model.Persons;
import com.example.ej63.CRUDS.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class updateController {

    @Autowired
    PersonsService personsService;

    //creating put mapping that updates the person detail
    @PutMapping("/updatePerson")
    private Persons update(@RequestBody Persons persons)
    {
        personsService.saveOrUpdate(persons);
        return persons;
    }
}
