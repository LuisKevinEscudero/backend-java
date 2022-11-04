package com.example.ej7.crudvalidation.person.controller;

import com.example.ej7.crudvalidation.person.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ADMIN")
public class deleteController {
    @Autowired
    PersonServiceImp personServiceImp;

    //creating a delete mapping that deletes a specified person
    @DeleteMapping("/deletePerson/{idPerson}")
    public void deletePerson(@PathVariable("idPerson") String idPerson) throws Exception {
        personServiceImp.deletePerson(idPerson);
    }

}
