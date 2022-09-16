package com.example.ej7.crudvalidation.teacher.model;

import com.example.ej7.crudvalidation.person.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profesores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
