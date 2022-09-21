package com.example.ej7.crudvalidation.student.model;


import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.stringSecuenceGenerator.PersonSequenceIdGenerator;
import com.example.ej7.crudvalidation.subject.model.Subject;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    /*@Id
    @Column(name = "student_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idStudent")
    @GenericGenerator(name = "idStudent",
            strategy = "com.example.ej7.crudvalidation.stringSecuenceGenerator.StudentSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = PersonSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = PersonSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "student"),
                    @org.hibernate.annotations.Parameter(name = PersonSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String idStudent;

    @OneToOne
    @JoinColumn(name = "idPersona")
    Person person;

    @Column(name = "horasPorSemana", nullable = false)
    Integer numHoursWeek;

    @Column(name = "comentarios")
    String coments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Teacher teacher;

    @Column(name = "rama", nullable = false)
    String branch;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    List<Subject> studies;

}
