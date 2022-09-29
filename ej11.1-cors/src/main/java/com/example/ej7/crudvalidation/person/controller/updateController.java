package com.example.ej7.crudvalidation.person.controller;

import com.example.ej7.crudvalidation.person.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.person.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.person.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://codepen.io/de4imo/pen/VwMRENP")
public class updateController {

    @Autowired
    PersonServiceImp personServiceImp;

    @PutMapping("/updatePerson/{idPerson}")
    public PersonOutputDTO updatePerson(@RequestBody PersonInputDTO person, @PathVariable String idPerson) throws Exception
    {
        personServiceImp.updatePerson(person, idPerson);
        return  personServiceImp.getPerson(idPerson);
    }
}
