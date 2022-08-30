package com.example.ej63.CRUDS.controller;

import com.example.ej63.CRUDS.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/persona")
@RestController
public class deteleController {

    @Autowired
    PersonsService personsService;

    //creating a delete mapping that deletes a specified person
    @DeleteMapping("/deletePerson/{personid}")
    private void deletePerson(@PathVariable("personid") int personid)
    {
        personsService.delete(personid);
    }
}
