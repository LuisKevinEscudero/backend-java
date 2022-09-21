package com.example.ej7.crudvalidation.subject.DTOs;

import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.subject.model.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectInputDTO {
    private String idSubject;
    private List<Student> students;
    private String signature;
    private String comment;
    private Date initialDate;
    private Date finishDate;

    public Subject toSubject(){
        Subject subject = new Subject();
        subject.setIdSubject(this.idSubject);
        subject.setStudents(this.students);
        subject.setSignature(this.signature);
        subject.setComment(this.comment);
        subject.setInitialDate(this.initialDate);
        subject.setFinishDate(this.finishDate);
        return subject;
    }
}
