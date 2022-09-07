package com.example.ej7.crudvalidation.service;

import com.example.ej7.crudvalidation.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.model.Person;
import com.example.ej7.crudvalidation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonServiceImp implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonOutputDTO createPerson(PersonInputDTO personInputDTO) throws Exception
    {

        Person person = new Person();

        person.createPerson(personInputDTO);

        if (personInputDTO.getName()==null)
        {
            throw new Exception("Name no puede ser nulo");
        }
        if(personInputDTO.getName().length()<3)
        {
            throw new Exception("Name debe tener al menos 3 caracteres");
        }
        if(personInputDTO.getName().length()>10)
        {
            throw new Exception("Name debe tener menos de 10 caracteres");
        }

        personRepository.save(person);

        return new PersonOutputDTO(person);
    }


    @Override
    public PersonOutputDTO updatePerson(PersonInputDTO personInputDTO, Integer id) throws Exception {
        return null;
    }

    @Override
    public PersonOutputDTO getPerson(Integer id) throws Exception {
        return null;
    }

    @Override
    public void deletePerson(Integer id) throws Exception {

    }

    @Override
    public List<Person> findByName(String name) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }
}
