package com.example.ej7.crudvalidation.subject.DTOs;

import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.subject.model.Subject;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectInputDTO {
    private Integer id;
    //private Teacher teacher;
    private Student student;
    private String asignatura;
    private String comment;
    private Date initial_date;
    private Date finish_date;

    public Subject toSubject(){
        Subject subject = new Subject();
        subject.setId(this.id);
        //subject.setStudent(this.student);
        subject.setAsignatura(this.asignatura);
        subject.setComment(this.comment);
        subject.setInitial_date(this.initial_date);
        subject.setFinish_date(this.finish_date);
        return subject;
    }
}
