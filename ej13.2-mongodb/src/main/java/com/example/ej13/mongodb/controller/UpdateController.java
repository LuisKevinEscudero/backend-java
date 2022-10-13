package com.example.ej13.mongodb.controller;

import com.example.ej13.mongodb.model.Person;
import com.example.ej13.mongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UpdateController {

    @Autowired
    private PersonRepository personRepository;

    @PutMapping("/updatePerson/{idPerson}")
    public Person updatePerson(Integer idPerson, @RequestBody Person person)
    {

        Optional<Person> personOptional = personRepository.findById(idPerson);
        if (personOptional.isPresent()) {
            Person personToUpdate = personOptional.get();
            personToUpdate.setUsername(person.getUsername());
            personToUpdate.setPassword(person.getPassword());
            personToUpdate.setName(person.getName());
            personToUpdate.setSurname(person.getSurname());
            personToUpdate.setCompanyEmail(person.getCompanyEmail());
            personToUpdate.setPersonalEmail(person.getPersonalEmail());
            personToUpdate.setCity(person.getCity());
            personToUpdate.setActive(person.isActive());
            personToUpdate.setCreatedDate(person.getCreatedDate());
            personToUpdate.setImageUrl(person.getImageUrl());
            personToUpdate.setTerminationDate(person.getTerminationDate());
            return personRepository.save(personToUpdate);
        } else
        {
            return null;
        }
    }
}
