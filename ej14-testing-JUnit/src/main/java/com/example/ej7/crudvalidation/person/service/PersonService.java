package com.example.ej7.crudvalidation.person.service;

import com.example.ej7.crudvalidation.person.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.person.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.person.model.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(PersonInputDTO personInputDTO) throws Exception;
    Person updatePerson(PersonInputDTO personInputDTO, String idPerson) throws Exception;
    PersonOutputDTO getPerson(String idPerson) throws Exception;
    void deletePerson(String idPerson) throws Exception;

    List<PersonOutputDTO> findByName(String name) throws Exception;
    List<Person> findAll();

}
