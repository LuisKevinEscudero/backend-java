package com.example.ej7.crudvalidation.controller;

import com.example.ej7.crudvalidation.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class createController {

    @Autowired
    PersonServiceImp personServiceImp;

    @PostMapping("/createPerson")
    private void createPerson(@RequestBody PersonInputDTO person) throws Exception {
        personServiceImp.createPerson(person);
    }
}
