package com.example.ej7.crudvalidation.person.controller;

import com.example.ej7.crudvalidation.exceptions.EntityNotFoundException;


import com.example.ej7.crudvalidation.person.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.person.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/USER")
public class readController {

    @Autowired
    PersonServiceImp personServiceImp;


    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons()
    {
        return personServiceImp.findAll();
    }
    //creating a get mapping that retrieves the detail of a specific person

    @GetMapping("/getPerson/{idPerson}")
    public PersonOutputDTO getPersons(@PathVariable("idPerson") String idPerson) throws Exception {
        return personServiceImp.getPerson(idPerson);
    }

    @GetMapping("/getPersonByName/{name}")
    public List<PersonOutputDTO> getPersonsByName(@PathVariable("name") String name) throws Exception
    {
        return personServiceImp.findByName(name);
    }



    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundException> handleStorageException(EntityNotFoundException exception) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exception.getMessage());
        return responseEntity;
    }


}
