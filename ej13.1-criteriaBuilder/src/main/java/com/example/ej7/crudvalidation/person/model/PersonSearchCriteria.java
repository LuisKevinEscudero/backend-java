package com.example.ej7.crudvalidation.person.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonSearchCriteria {
    private String username;
    private String name;
    private String surname;
    private Date createdDate;
    private String criteriaDate;
}
