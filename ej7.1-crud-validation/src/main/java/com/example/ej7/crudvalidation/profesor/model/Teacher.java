package com.example.ej7.crudvalidation.profesor.model;

import com.example.ej7.crudvalidation.person.model.Person;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profesores")
@Data
public class Teacher implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "idPersona")
    Person person;

    @Column(name = "comentarios")
    String coments;

    @Column(name = "rama")
    String branch;

}
