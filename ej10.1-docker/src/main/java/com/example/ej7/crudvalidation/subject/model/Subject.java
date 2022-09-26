package com.example.ej7.crudvalidation.subject.model;

import com.example.ej7.crudvalidation.stringSecuenceGenerator.PersonSequenceIdGenerator;
import com.example.ej7.crudvalidation.student.model.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
    /*@Id
    @Column(name = "subject_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;*/

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSubject")
    @GenericGenerator(name = "idSubject",
            strategy = "com.example.ej7.crudvalidation.stringSecuenceGenerator.SubjectSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = PersonSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = PersonSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "subject"),
                    @org.hibernate.annotations.Parameter(name = PersonSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String idSubject;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "estudiantes_asignaturas",
            joinColumns = @JoinColumn(name = "id_asignatura", referencedColumnName = "idSubject"),
            inverseJoinColumns = @JoinColumn(name = "id_estudiante", referencedColumnName = "idStudent")
    )
    List<Student> students;

    @Column(name = "asignatura", nullable = false)
    String signature;

    @Column(name = "comentarios")
    String comment;

    @Column(name = "fecha_inicial")
    Date initialDate;

    @Column(name = "fecha_final")
    Date finishDate;

}
