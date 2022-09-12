package com.example.ej7.crudvalidation.service;

import com.example.ej7.crudvalidation.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.model.Person;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface PersonService {
    void createPerson(PersonInputDTO personInputDTO) throws Exception;
    void updatePerson(PersonInputDTO personInputDTO, Integer id) throws Exception;
    PersonOutputDTO getPerson(Integer id) throws Exception;
    void deletePerson(Integer id) throws Exception;

    List<PersonOutputDTO> findByName(String name) throws Exception;
    List<Person> findAll();

}
