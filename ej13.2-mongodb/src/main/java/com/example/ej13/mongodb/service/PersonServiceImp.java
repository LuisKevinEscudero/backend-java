package com.example.ej13.mongodb.service;

import com.example.ej13.mongodb.model.Person;
import com.example.ej13.mongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        Optional<Person> personOptional = personRepository.findById(person.getIdPerson());
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
        }
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Integer idPerson) {
        personRepository.deleteById(idPerson);
    }

    @Override
    public Person getPersonById(Integer idPerson) {
        return personRepository.findById(idPerson).orElse(null);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

}
