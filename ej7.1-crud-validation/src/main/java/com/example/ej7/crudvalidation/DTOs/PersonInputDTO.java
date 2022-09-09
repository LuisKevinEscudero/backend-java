package com.example.ej7.crudvalidation.DTOs;

import com.example.ej7.crudvalidation.model.Person;
import lombok.Data;
import java.util.Date;

@Data
public class PersonInputDTO {
   // private int id_persona;
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

    public Person toPerson() {
        Person person = new Person();
        person.setUsername(this.getUsername());
        person.setPassword(this.getPassword());
        person.setName(this.getName());
        person.setSurname(this.getSurname());
        person.setCompanyEmail(this.getCompanyEmail());
        person.setPersonalEmail(this.getPersonalEmail());
        person.setCity(this.getCity());
        person.setActive(this.getActive());
        person.setCreatedDate(this.getCreatedDate());
        person.setImageUrl(this.getImageUrl());
        person.setTerminationDate(this.getTerminationDate());

        return person;
    }


}
