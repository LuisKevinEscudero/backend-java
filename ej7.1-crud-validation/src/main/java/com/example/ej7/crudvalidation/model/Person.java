package com.example.ej7.crudvalidation.model;

import com.example.ej7.crudvalidation.DTOs.PersonInputDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "personas")
//@Table(name = "personas")
public class Person {
    @Id
    @Column
    @GeneratedValue
    private int id_persona;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column
    private String surname;

    @Column(nullable = false)
    private String company_email;

    @Column(nullable = false)
    private String personal_email;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Boolean active;

    @Column//(nullable = false)
    private Date created_date;

    @Column
    private String image_url;

    @Column
    private Date termination_date;

   public void createPerson(PersonInputDTO personaInputDTO)
   {
       this.username = personaInputDTO.getUsername();
       this.password = personaInputDTO.getPassword();
       this.name = personaInputDTO.getName();
       this.surname = personaInputDTO.getSurname();
       this.company_email = personaInputDTO.getCompany_email();
       this.personal_email = personaInputDTO.getPersonal_email();
       this.city = personaInputDTO.getCity();
       this.active = personaInputDTO.getActive();
       this.created_date = personaInputDTO.getCreated_date();
       this.image_url = personaInputDTO.getImage_url();
       this.termination_date = personaInputDTO.getTermination_date();
   }

}
