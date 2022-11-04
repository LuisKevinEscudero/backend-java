package com.example.ej7.crudvalidation.person.controller;

import com.example.ej7.crudvalidation.person.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.person.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ADMIN")
public class createController {

    @Autowired
    PersonServiceImp personServiceImp;

    @PostMapping("/createPerson")
    public void createPerson(@RequestBody PersonInputDTO person) throws Exception {
        personServiceImp.createPerson(person);
    }
}
