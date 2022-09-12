package com.example.ej7.crudvalidation.person.controller;

import com.example.ej7.crudvalidation.person.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.person.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.person.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class updateController {

    @Autowired
    PersonServiceImp personServiceImp;

    @PutMapping("/updatePerson/{id}")
    private PersonOutputDTO updatePerson(@RequestBody PersonInputDTO person, @PathVariable Integer id) throws Exception
    {
        personServiceImp.updatePerson(person, id);
        return  personServiceImp.getPerson(id);
    }
}
