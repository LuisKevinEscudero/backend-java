package com.example.ej7.crudvalidation.person.service;

import com.example.ej7.crudvalidation.person.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.person.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.example.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class PersonServiceImp implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void createPerson(PersonInputDTO personInputDTO) throws Exception
    {
        Person person = personInputDTO.toPerson();

        if (person.getUsername() == null || person.getUsername().isEmpty()) {
            throw new UnprocessableEntityException("username no puede ser nulo",422);
        }
        if(person.getUsername().length() < 3) {
            throw new UnprocessableEntityException("username debe tener al menos 3 caracteres",422);
        }
        if(person.getUsername().length() > 10) {
            throw new UnprocessableEntityException("username debe tener menos de 10 caracteres",422);
        }
        if (person.getPassword() == null || person.getPassword().isEmpty()) {
            throw new UnprocessableEntityException("password no puede ser nulo",422);
        }
        if (person.getName()==null)
        {
            throw new UnprocessableEntityException("Name no puede ser nulo",422);
        }
        if(person.getCompanyEmail() == null || person.getCompanyEmail().isEmpty()) {
            throw new UnprocessableEntityException("companyEmail no puede ser nulo",422);
        }
        if (!person.getCompanyEmail().contains("@")) {
            throw new UnprocessableEntityException("companyEmail debe contener @",422);
        }
        if(!person.getCompanyEmail().contains(".com") && !person.getCompanyEmail().contains(".es")) {
            throw new UnprocessableEntityException("companyEmail debe contener .com o .es",422);
        }
        if (!person.getPersonalEmail().contains("@")) {
            throw new UnprocessableEntityException("companyEmail debe contener @",422);
        }
        if(!person.getPersonalEmail().contains(".com") && !person.getPersonalEmail().contains(".es")) {
            throw new UnprocessableEntityException("companyEmail debe contener .com o .es",422);
        }
        if(person.getPersonalEmail() == null || person.getPersonalEmail().isEmpty()) {
            throw new UnprocessableEntityException("personalEmail no puede ser nulo",422);
        }
        if(person.getCity() == null || person.getCity().isEmpty()) {
            throw new UnprocessableEntityException("city no puede ser nulo",422);
        }
        person.setCreatedDate(new java.util.Date());

        personRepository.save(person);

    }


    @Override
    public void updatePerson(PersonInputDTO personInputDTO, String idPerson) throws Exception
    {
        Optional<Person> personOptional = personRepository.findById(idPerson);

        if (personOptional.isPresent())
        {
            Person person = personOptional.get();
            person.setUsername(personInputDTO.getUsername());
            person.setPassword(personInputDTO.getPassword());
            person.setName(personInputDTO.getName());
            person.setCompanyEmail(personInputDTO.getCompanyEmail());
            person.setPersonalEmail(personInputDTO.getPersonalEmail());
            person.setCity(personInputDTO.getCity());
            personRepository.save(person);

        }
        else
        {
            throw new EntityNotFoundException("No existe la persona",404);
        }
    }

    @Override
    public PersonOutputDTO getPerson(String idPerson) throws Exception
    {
        return personRepository
                .findById(idPerson)
                .map(PersonOutputDTO::of)
                .orElseThrow(() -> new EntityNotFoundException("No existe la persona con id " + idPerson,404));
    }


    @Override
    public void deletePerson(String idPerson) throws Exception {
        //personRepository.deleteById(id);
        Optional<Person> personOptional = personRepository.findById(idPerson);
        if (personOptional.isPresent())
        {
            Person person = personOptional.get();
            personRepository.delete(person);
        }
        else
        {
            throw new EntityNotFoundException("No existe la persona con id " + idPerson,404);
        }
    }

    @Override
    public List<PersonOutputDTO> findByName(String name) throws Exception
    {
        List<PersonOutputDTO> personOptional = personRepository.findByName(name);
        if (personOptional.isEmpty())
        {
            throw new EntityNotFoundException("No existe la persona con nombre " + name,404);
        }
        else
        {
            return personOptional;
        }
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
