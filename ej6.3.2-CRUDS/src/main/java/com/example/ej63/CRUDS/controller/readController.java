package com.example.ej63.CRUDS.controller;

import com.example.ej63.CRUDS.model.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ej63.CRUDS.service.PersonsService;

import java.util.List;

@RequestMapping("/persona")
@RestController
public class readController {

    //autowire the PersonsService class  
    @Autowired
    PersonsService personsService;
    //creating a get mapping that retrieves all the persons detail from the database   
    @GetMapping("/getAllPersons")
    private List<Persons> getAllPersons()
    {
        return personsService.getAllPersons();
    }
    //creating a get mapping that retrieves the detail of a specific person  

    @GetMapping("/getPerson/{personid}")
    private Persons getPersons(@PathVariable("personid") int personid)
    {
        return personsService.getPersonsById(personid);
    }

    @GetMapping("/getPersonByName/{name}")
    private List<Persons> getPersonsByName(@PathVariable("name") String name)
    {
        return personsService.getPersonsByName(name);
    }

    
}
