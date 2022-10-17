package com.example.ej13.mongodb.service;

import com.example.ej13.mongodb.model.Person;

import java.util.List;

public interface PersonService {
    public void createPerson(Person person);
    public void updatePerson(Person person);
    public void deletePerson(Integer idPerson);
    public Person getPersonById(Integer idPerson);
    public List<Person> getAllPersons();
}
