package com.example.ej7.crudvalidation.DTOs;

import lombok.Data;
import java.util.Date;

@Data
public class PersonInputDTO {
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
}
