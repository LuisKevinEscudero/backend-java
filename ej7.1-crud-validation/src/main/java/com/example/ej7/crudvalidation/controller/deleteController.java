package com.example.ej7.crudvalidation.controller;

import com.example.ej7.crudvalidation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class deleteController {
    @Autowired
    PersonService personService;

    //creating a delete mapping that deletes a specified person
    @DeleteMapping("/deletePerson/{personid}")
    private void deletePerson(@PathVariable("personid") int personid)
    {
        personService.delete(personid);
    }

}
