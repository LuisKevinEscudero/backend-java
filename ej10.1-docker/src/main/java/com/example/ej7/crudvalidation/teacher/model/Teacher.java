package com.example.ej7.crudvalidation.teacher.model;

import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.stringSecuenceGenerator.PersonSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profesor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Teacher implements Serializable {
    /*@Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;*/

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idTeacher")
    @GenericGenerator(name = "idTeacher",
            strategy = "com.example.ej7.crudvalidation.stringSecuenceGenerator.TeacherSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = PersonSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = PersonSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "teacher"),
                    @org.hibernate.annotations.Parameter(name = PersonSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String idTeacher;

    @OneToOne
    @JoinColumn(name = "idPersona")
    Person person;

    @Column(name = "comentarios")
    String coments;

    @Column(name = "rama", nullable = false)
    String branch;

}
