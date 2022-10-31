package com.example.ej7.crudvalidation.person.DTOs;

import com.example.ej7.crudvalidation.person.model.Person;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDTO {

    private String idPerson;
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
    private Boolean admin;

    public Person toPersonOutputDTO(Person person)
    {
        this.idPerson = person.getIdPerson();
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
        this.admin = person.getAdmin();

        return person;
    }

    public static PersonOutputDTO of(Person person) {
        PersonOutputDTO personOutputDTO = new PersonOutputDTO();
        personOutputDTO.setIdPerson(person.getIdPerson());
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
        personOutputDTO.setAdmin(person.getAdmin());
        return personOutputDTO;
    }



}
