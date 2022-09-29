package com.example.ej7.crudvalidation.person.DTOs;

import com.example.ej7.crudvalidation.person.model.Person;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDTO {
   // private int id_persona;
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


    public Person toPerson() {
        Person person = new Person();
        person.setUsername(this.getUsuario());
        person.setPassword(this.getPassword());
        person.setName(this.getName());
        person.setSurname(this.getSurname());
        person.setCompanyEmail(this.getCompany_email());
        person.setPersonalEmail(this.getPersonal_email());
        person.setCity(this.getCity());
        person.setActive(this.getActive());
        person.setCreatedDate(this.getCreated_date());
        person.setImageUrl(this.getImagen_url());
        person.setTerminationDate(this.getTermination_date());

        return person;
    }


}
