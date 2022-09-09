package com.example.ej7.crudvalidation.service;

import com.example.ej7.crudvalidation.DTOs.PersonInputDTO;
import com.example.ej7.crudvalidation.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.model.Person;
import com.example.ej7.crudvalidation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonServiceImp implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonOutputDTO createPerson(PersonInputDTO personInputDTO) throws Exception
    {

        Person person = personInputDTO.toPerson();

        if (person.getUsername() == null || person.getUsername().isEmpty()) {
            throw new Exception("username no puede ser nulo");
        }
        if(person.getUsername().length() < 3) {
            throw new Exception("username debe tener al menos 3 caracteres");
        }
        if(person.getUsername().length() > 10) {
            throw new Exception("username debe tener menos de 10 caracteres");
        }
        if (person.getPassword() == null || person.getPassword().isEmpty()) {
            throw new Exception("password no puede ser nulo");
        }
        if (person.getName()==null)
        {
            throw new Exception("Name no puede ser nulo");
        }
        if(person.getCompanyEmail() == null || person.getCompanyEmail().isEmpty()) {
            throw new Exception("companyEmail no puede ser nulo");
        }
        if (!person.getCompanyEmail().contains("@")) {
            throw new Exception("companyEmail debe contener @");
        }
        if(!person.getCompanyEmail().contains(".com") && !person.getCompanyEmail().contains(".es")) {
            throw new Exception("companyEmail debe contener .com o .es");
        }
        if (!person.getPersonalEmail().contains("@")) {
            throw new Exception("companyEmail debe contener @");
        }
        if(!person.getPersonalEmail().contains(".com") && !person.getPersonalEmail().contains(".es")) {
            throw new Exception("companyEmail debe contener .com o .es");
        }
        if(person.getPersonalEmail() == null || person.getPersonalEmail().isEmpty()) {
            throw new Exception("personalEmail no puede ser nulo");
        }
        if(person.getCity() == null || person.getCity().isEmpty()) {
            throw new Exception("city no puede ser nulo");
        }

        personRepository.save(person);

        return new PersonOutputDTO();
    }


    @Override
    public PersonOutputDTO updatePerson(PersonInputDTO personInputDTO, Integer id) throws Exception {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            person.setUsername(personInputDTO.getUsername());
            person.setPassword(personInputDTO.getPassword());
            person.setName(personInputDTO.getName());
            person.setCompanyEmail(personInputDTO.getCompanyEmail());
            person.setPersonalEmail(personInputDTO.getPersonalEmail());
            person.setCity(personInputDTO.getCity());
            personRepository.save(person);
            return new PersonOutputDTO();
        } else {
            throw new Exception("No existe la persona");
        }

    }

    @Override
    public PersonOutputDTO getPerson(Integer id) throws Exception
    {
        return personRepository
                .findById(id)
                .map(PersonOutputDTO::of)
                .orElseThrow(() -> new Exception("No existe la persona con id " + id));
    }

    @Override
    public void deletePerson(Integer id) throws Exception {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
