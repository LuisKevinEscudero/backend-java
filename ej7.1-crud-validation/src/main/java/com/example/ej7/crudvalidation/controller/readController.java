package com.example.ej7.crudvalidation.controller;

import com.example.ej7.crudvalidation.model.Person;
import com.example.ej7.crudvalidation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class readController {

    @Autowired
    PersonService personService;


    @GetMapping("/getAllPersons")
    private List<Person> getAllPersons()
    {
        return personService.getAllPersons();
    }
    //creating a get mapping that retrieves the detail of a specific person

    @GetMapping("/getPerson/{personid}")
    private Person getPersons(@PathVariable("personid") int personid)
    {
        return personService.getPersonById(personid);
    }

    @GetMapping("/getPersonByName/{name}")
    private List<Person> getPersonsByName(@PathVariable("name") String name)
    {
        return personService.getPersonByName(name);
    }

}
