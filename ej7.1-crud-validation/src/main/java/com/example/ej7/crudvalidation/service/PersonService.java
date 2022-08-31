package com.example.ej7.crudvalidation.service;

import com.example.ej7.crudvalidation.model.Person;
import com.example.ej7.crudvalidation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons()
    {
        List<Person> person = new ArrayList<Person>();
        personRepository.findAll().forEach(person1 -> person.add(person1));
        return person;
    }

    public Person getPersonById(int personid)
    {
        return personRepository.findById(personid).get();
    }

    public void saveOrUpdate(Person person)
    {
        personRepository.save(person);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        personRepository.deleteById(id);
    }
    //updating a record
    public void update(Person person, int personid)
    {
        personRepository.save(person);
    }

    public List<Person> getPersonByName(String name)
    {
        List<Person> person = new ArrayList<Person>();
        personRepository.findByName(name).forEach(person1 -> person.add(person1));
        return person;
    }
}
