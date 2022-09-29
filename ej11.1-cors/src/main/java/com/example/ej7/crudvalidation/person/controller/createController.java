package com.example.ej7.crudvalidation.person.controller;

import com.example.ej7.crudvalidation.person.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.person.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://cdpn.io")
public class createController {

    @Autowired
    PersonServiceImp personServiceImp;

    @PostMapping("/addperson")
    public void createPerson(@RequestBody PersonInputDTO person) throws Exception {
        personServiceImp.createPerson(person);
    }
}
