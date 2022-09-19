package com.example.ej7.crudvalidation.subject.model;

import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "asignaturas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Subject implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "estudiantes_asignaturas",
            joinColumns = @JoinColumn(name = "id_asignatura", referencedColumnName = "id_asignatura"),
            inverseJoinColumns = @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
    )
    private List<Student> students;

    @Column(name = "asignatura")
    String asignatura;

    @Column(name = "comentarios")
    String comment;

    @Column(name = "fecha_inicial")
    Date initial_date;

    @Column(name = "fecha_final")
    Date finish_date;

}
