package com.example.ej7.crudvalidation;

import com.example.ej7.crudvalidation.person.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.person.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.person.repository.PersonRepository;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PersonTest {

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    public void setUp() {
        personRepository.deleteAll();
    }

    // este test ya esta echo en el service
    @Test
    public void findByNameTest() throws Exception {
        PersonInputDTO personInputDTO = new PersonInputDTO("username", "password", "name", "surname", "companyEmail@aaa.com", "personalEmail@oo.es", "city", true, new Date(), "imageUrl", new Date());

        personRepository.save(personInputDTO.toPerson());

        List<PersonOutputDTO> personInputDTOList = personRepository.findByName("name").stream().toList();

        assertEquals(personInputDTOList.get(0).getName(), "name");

    }
}
