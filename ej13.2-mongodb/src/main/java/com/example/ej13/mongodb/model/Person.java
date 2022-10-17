package com.example.ej13.mongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "person")
public class Person {
    @Id
    private Integer idPerson;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private String createdDate;
    private String imageUrl;
    private String terminationDate;

}
