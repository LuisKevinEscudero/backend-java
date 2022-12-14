package com.example.ej63.CRUDS.service;

import com.example.ej63.CRUDS.model.Persons;
import com.example.ej63.CRUDS.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonsService {
    @Autowired
    PersonsRepository personsRepository;
    //getting all persons record by using the method findaAll() of CrudRepository
    public List<Persons> getAllPersons()
    {
        List<Persons> persons = new ArrayList<Persons>();
        personsRepository.findAll().forEach(persons1 -> persons.add(persons1));
        return persons;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Persons getPersonsById(int id)
    {
        return personsRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Persons persons)
    {
        personsRepository.save(persons);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        personsRepository.deleteById(id);
    }
    //updating a record
    public void update(Persons persons, int personid)
    {
        personsRepository.save(persons);
    }

    public List<Persons> getPersonsByName(String name)
    {
        List<Persons> persons = new ArrayList<Persons>();
        personsRepository.findByName(name).forEach(persons1 -> persons.add(persons1));
        return persons;
    }
}
