package com.example.ej7.crudvalidation.person.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table
public class Person implements Serializable {
    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column
    private String surname;

    @Column(nullable = false)
    private String companyEmail;

    @Column(nullable = false)
    private String personalEmail;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Boolean active;

    @Column//(nullable = false)
    private Date createdDate;

    @Column
    private String imageUrl;

    @Column
    private Date terminationDate;

    public boolean getActive() {
        return this.active;
    }
}
