package com.example.ej7.crudvalidation.service;

import com.example.ej7.crudvalidation.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.model.Person;

import java.util.List;

public interface PersonService {
    PersonOutputDTO createPerson(PersonInputDTO personInputDTO) throws Exception;
    PersonOutputDTO updatePerson(PersonInputDTO personInputDTO, Integer id) throws Exception;
    PersonOutputDTO getPerson(Integer id) throws Exception;
    void deletePerson(Integer id) throws Exception;

    List<Person> findByName(String name);
    List<Person> findAll();

}
