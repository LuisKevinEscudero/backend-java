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
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public Person toPersonOutputDTO(Person person)
    {
        this.idPerson = person.getIdPerson();
        this.usuario = person.getUsername();
        this.password = person.getPassword();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.company_email = person.getCompanyEmail();
        this.personal_email = person.getPersonalEmail();
        this.city = person.getCity();
        this.active = person.getActive();
        this.created_date = person.getCreatedDate();
        this.imagen_url = person.getImageUrl();
        this.termination_date = person.getTerminationDate();

        return person;
    }

    public static PersonOutputDTO of(Person person) {
        PersonOutputDTO personOutputDTO = new PersonOutputDTO();
        personOutputDTO.setIdPerson(person.getIdPerson());
        personOutputDTO.setUsuario(person.getUsername());
        personOutputDTO.setPassword(person.getPassword());
        personOutputDTO.setName(person.getName());
        personOutputDTO.setSurname(person.getSurname());
        personOutputDTO.setCompany_email(person.getCompanyEmail());
        personOutputDTO.setPersonal_email(person.getPersonalEmail());
        personOutputDTO.setCity(person.getCity());
        personOutputDTO.setActive(person.getActive());
        personOutputDTO.setCreated_date(person.getCreatedDate());
        personOutputDTO.setImagen_url(person.getImageUrl());
        personOutputDTO.setTermination_date(person.getTerminationDate());
        return personOutputDTO;
    }



}
