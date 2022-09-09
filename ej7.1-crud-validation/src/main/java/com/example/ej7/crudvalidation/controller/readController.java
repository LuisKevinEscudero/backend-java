package com.example.ej7.crudvalidation.controller;

import com.example.ej7.crudvalidation.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.model.Person;
import com.example.ej7.crudvalidation.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class readController {

    @Autowired
    PersonServiceImp personServiceImp;


    @GetMapping("/getAllPersons")
    private List<Person> getAllPersons()
    {
        return personServiceImp.findAll();
    }
    //creating a get mapping that retrieves the detail of a specific person

    @GetMapping("/getPerson/{personid}")
    private PersonOutputDTO getPersons(@PathVariable("personid") int personid) throws Exception {
        //return personService.getPersonById(personid);
        return personServiceImp.getPerson(personid);
    }

    @GetMapping("/getPersonByName/{name}")
    private List<PersonOutputDTO> getPersonsByName(@PathVariable("name") String name)
    {
        return personServiceImp.findByName(name);
    }

}
