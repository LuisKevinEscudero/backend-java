package com.example.ej63.CRUDS.controller;

import com.example.ej63.CRUDS.model.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ej63.CRUDS.service.PersonsService;

import java.util.List;

@RestController
public class PersonsController {

    //autowire the PersonsService class  
    @Autowired
    PersonsService personsService;
    //creating a get mapping that retrieves all the persons detail from the database   
    @GetMapping("/person")
    private List<Persons> getAllPersons()
    {
        return personsService.getAllPersons();
    }
    //creating a get mapping that retrieves the detail of a specific person  
    @GetMapping("/person/{personid}")
    private Persons getPersons(@PathVariable("personid") int personid)
    {
        return personsService.getPersonsById(personid);
    }
    //creating a delete mapping that deletes a specified person  
    @DeleteMapping("/person/{personid}")
    private void deletePerson(@PathVariable("personid") int personid)
    {
        personsService.delete(personid);
    }
    //creating post mapping that post the person detail in the database  
    @PostMapping("/persons")
    private int savePerson(@RequestBody Persons persons)
    {
        personsService.saveOrUpdate(persons);
        return persons.getPersonId();
    }
    //creating put mapping that updates the person detail   
    @PutMapping("/persons")
    private Persons update(@RequestBody Persons persons)
    {
        personsService.saveOrUpdate(persons);
        return persons;
    }

    @GetMapping("hola")
    private String hola()
    {
        return "hola";
    }
    
}
