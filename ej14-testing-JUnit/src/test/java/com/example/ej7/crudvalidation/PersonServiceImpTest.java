package com.example.ej7.crudvalidation;


import com.example.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.example.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.example.ej7.crudvalidation.person.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.person.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.person.repository.PersonRepository;
import com.example.ej7.crudvalidation.person.service.PersonService;
import com.example.ej7.crudvalidation.person.service.PersonServiceImp;

import com.example.ej7.crudvalidation.student.repository.StudentRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceImpTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private PersonService personService = new PersonServiceImp();

    PersonInputDTO personInputDTO=null; //new PersonInputDTO("username", "password", "name", "surname", "companyEmail@aaa.com", "personalEmail@oo.es", "city", true, new Date(), "imageUrl", new Date());
    Person person = null;
    PersonOutputDTO personOutputDTO = null;
    List<PersonOutputDTO> personOutputDTOList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        personInputDTO= new PersonInputDTO("username", "password", "name", "surname", "companyEmail@aaa.com", "personalEmail@oo.es", "city", true, new Date(), "imageUrl", new Date());
        person = personInputDTO.toPerson();
        personOutputDTO = new PersonOutputDTO();
        personOutputDTO.setName("name");
        personOutputDTO.setSurname("surname");
        personOutputDTO.setCompanyEmail("companyEmail");
        personOutputDTO.setPersonalEmail("personalEmail");
        personOutputDTO.setCity("city");
        personOutputDTO.setActive(true);
        personOutputDTO.setCreatedDate(new Date());
        personOutputDTO.setImageUrl("imageUrl");
        personOutputDTOList.add(personOutputDTO);
        System.out.println("setUp");
    }

    @Test
    public void canFindAll() throws Exception {

        personService.findAll();

        verify(personRepository).findAll();
    }

    @Test
    public void canAddPerson() throws Exception {
        System.out.println("canAddPerson");

        Person person = personService.createPerson(personInputDTO);
        assertThat(person).isNotNull();
        verify(personRepository).save(person);
    }


    @Test
    public void nullUsernameException() throws Exception {
        System.out.println("nullUsernameException");

        personInputDTO.setUsername(null);
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void shortLengthUsernameException() throws Exception {
        System.out.println("shortLengthUsernameException");

        personInputDTO.setUsername("a");
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void longLengthUsernameException() throws Exception{
        System.out.println("longLengthUsernameException");

        personInputDTO.setUsername("adqwdqawdqwdqwdqwdqwd");
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void nullPasswordException() throws Exception {
        System.out.println("nullPasswordException");

        personInputDTO.setPassword(null);
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void shortLengthPasswordException() throws Exception {
        System.out.println("shortLengthPasswordException");

        personInputDTO.setPassword("a");
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void nullNameException() throws Exception {
        System.out.println("nullNameException");

        personInputDTO.setName(null);
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void shortLengthNameException() throws Exception {
        System.out.println("shortLengthNameException");

        personInputDTO.setName("a");
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void nullCompanyEmailException() throws Exception {
        System.out.println("nullCompanyEmailException");

        personInputDTO.setCompanyEmail(null);
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void shortLengthCompanyEmailException() throws Exception {
        System.out.println("shortLengthCompanyEmailException");

        personInputDTO.setCompanyEmail("a");
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void notValidCompanyEmailException() throws Exception {
        System.out.println("notValidCompanyEmailException");

        personInputDTO.setCompanyEmail("aaaaaa");
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void incompleteCompanyEmailException() throws Exception {
        System.out.println("incompleteCompanyEmailException");

        personInputDTO.setCompanyEmail("aaaaaa@");
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void nullPersonalEmailException() throws Exception {
        System.out.println("nullPersonalEmailException");

        personInputDTO.setPersonalEmail(null);
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void shortLengthPersonalEmailException() throws Exception {
        System.out.println("shortLengthPersonalEmailException");

        personInputDTO.setPersonalEmail("a");
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void notValidPersonalEmailException() throws Exception {
        System.out.println("notValidPersonalEmailException");

        personInputDTO.setPersonalEmail("aaaaaa");
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void incompletePersonalEmailException() throws Exception {
        System.out.println("incompletePersonalEmailException");

        personInputDTO.setPersonalEmail("aaaaaa@");
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }


    @Test
    public void nullCityException() throws Exception {
        System.out.println("nullCityException");

        personInputDTO.setCity(null);
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void shortLengthCityException() throws Exception {
        System.out.println("shortLengthCityException");

        personInputDTO.setCity("a");
        assertThrows(UnprocessableEntityException.class, () -> personService.createPerson(personInputDTO));
        verify(personRepository, never()).save(person);
    }

    @Test
    public void canFindById() throws Exception {
        System.out.println("canFindById");

        String id= "person-00001";
        when(personRepository.findById(id)).thenReturn(Optional.of(person));
        personRepository.findById(id);
        verify(personRepository).findById(id);
    }

    @Test
    public void canUpdatePerson() throws Exception {
        System.out.println("canUpdatePerson");

        String id= "person-00001";
        given(personRepository.findById(id)).willReturn(Optional.of(person));

        personInputDTO.setUsername("juli223");
        personInputDTO.setName("julian");

        personService.updatePerson(personInputDTO, id);
        verify(personRepository).save(person);

        assertThat(person.getUsername()).isEqualTo(personInputDTO.getUsername());
        assertThat(person.getName()).isEqualTo(personInputDTO.getName());
        assertThat(person.getCompanyEmail()).isEqualTo(personInputDTO.getCompanyEmail());
        assertThat(person.getPersonalEmail()).isEqualTo(personInputDTO.getPersonalEmail());
        assertThat(person.getCity()).isEqualTo(personInputDTO.getCity());
        assertThat(person.getCreatedDate()).isEqualTo(personInputDTO.getCreatedDate());
        assertThat(person.getTerminationDate()).isEqualTo(personInputDTO.getTerminationDate());
        assertThat(person.getActive()).isEqualTo(personInputDTO.getActive());
        assertThat(person.getImageUrl()).isEqualTo(personInputDTO.getImageUrl());
        assertThat(person.getPassword()).isEqualTo(personInputDTO.getPassword());
    }

    @Test
    public void UpdatePersonException() throws Exception {
        System.out.println("UpdatePersonException");
        String id = "person-00001";

        given(personRepository.findById("person-00001")).willReturn(Optional.ofNullable(null));

        personInputDTO.setUsername("juli223");
        personInputDTO.setName("julian");

        assertThrows(EntityNotFoundException.class, () -> personService.updatePerson(personInputDTO,id));

        verify(personRepository, never()).save(personInputDTO.toPerson());
    }

    @Test
    void canDeletePerson() throws Exception {
        System.out.println("canDeletePerson");
        String id = "person-00001";

        given(personRepository.findById(id)).willReturn(Optional.of(person));
        willDoNothing().given(personRepository).delete(person);

        personService.deletePerson(id);

        verify(personRepository).delete(person);
    }

    @Test
    void deletePersonException() throws Exception {
        System.out.println("deletePersonException");
        String id = "person-00001";

        given(personRepository.findById(id)).willReturn(Optional.ofNullable(null));

        assertThrows(EntityNotFoundException.class, () -> personService.deletePerson(id));

        verify(personRepository, never()).delete(person);
    }

    @Test
    public void canFindByName() throws Exception {
        System.out.println("canFindByName");

        String name= "julian";
        when(personRepository.findByName(name)).thenReturn(personOutputDTOList);
        personRepository.findByName(name);
        verify(personRepository).findByName(name);
    }

    @Test
    public void findByNameException() throws Exception {
        System.out.println("findByNameException");

        String name= "julian";
        when(personRepository.findByName(name)).thenReturn(null);
        assertThrows(EntityNotFoundException.class, () -> personService.findByName(name));
    }


}
