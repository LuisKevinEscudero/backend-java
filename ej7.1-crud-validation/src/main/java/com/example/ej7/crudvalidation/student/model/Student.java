package com.example.ej7.crudvalidation.student.model;


import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.subject.model.Subject;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "idPersona")
    Person person;

    @Column(name = "horasPorSemana")
    Integer numHoursWeek;

    @Column(name = "comentarios")
    String coments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Teacher teacher;

    @Column(name = "rama")
    String branch;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    List<Subject> studies;

}
