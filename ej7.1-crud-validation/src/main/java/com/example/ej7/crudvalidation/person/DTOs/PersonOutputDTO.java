package com.example.ej7.crudvalidation.person.DTOs;

import com.example.ej7.crudvalidation.person.model.Person;
import lombok.Data;

import java.util.Date;

@Data
public class PersonOutputDTO {

    private int id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private Date createdDate;
    private String imageUrl;
    private Date terminationDate;

    public Person toPersonOutputDTO(Person person)
    {
        this.id = person.getId();
        this.username = person.getUsername();
        this.password = person.getPassword();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.companyEmail = person.getCompanyEmail();
        this.personalEmail = person.getPersonalEmail();
        this.city = person.getCity();
        this.active = person.getActive();
        this.createdDate = person.getCreatedDate();
        this.imageUrl = person.getImageUrl();
        this.terminationDate = person.getTerminationDate();

        return person;
    }

    public static PersonOutputDTO of(Person person) {
        PersonOutputDTO personOutputDTO = new PersonOutputDTO();
        personOutputDTO.setId(person.getId());
        personOutputDTO.setUsername(person.getUsername());
        personOutputDTO.setPassword(person.getPassword());
        personOutputDTO.setName(person.getName());
        personOutputDTO.setSurname(person.getSurname());
        personOutputDTO.setCompanyEmail(person.getCompanyEmail());
        personOutputDTO.setPersonalEmail(person.getPersonalEmail());
        personOutputDTO.setCity(person.getCity());
        personOutputDTO.setActive(person.getActive());
        personOutputDTO.setCreatedDate(person.getCreatedDate());
        personOutputDTO.setImageUrl(person.getImageUrl());
        personOutputDTO.setTerminationDate(person.getTerminationDate());
        return personOutputDTO;
    }

}
