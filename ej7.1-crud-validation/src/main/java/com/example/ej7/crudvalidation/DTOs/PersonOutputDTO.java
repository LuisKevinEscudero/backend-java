package com.example.ej7.crudvalidation.DTOs;

import com.example.ej7.crudvalidation.model.Person;
import lombok.Data;

import java.util.Date;

@Data
public class PersonOutputDTO {

    private int id_persona;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;

    public Person PersonaInputDTO(Person person) {
        //this.id_persona = person.getId_persona();
        this.username = person.getUsername();
        this.password = person.getPassword();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.company_email = person.getCompany_email();
        this.personal_email = person.getPersonal_email();
        this.city = person.getCity();
        this.active = person.getActive();
        this.created_date = person.getCreated_date();
        this.image_url = person.getImage_url();
        this.termination_date = person.getTermination_date();

        return person;
    }

}
