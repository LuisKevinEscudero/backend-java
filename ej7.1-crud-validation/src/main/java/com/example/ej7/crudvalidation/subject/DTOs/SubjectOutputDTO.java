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
public class SubjectOutputDTO {

    private String idSubject;
    private List <Student> students;
    private String signature;
    private String comment;
    private Date initialDate;
    private Date finishDate;

    public static SubjectOutputDTO of(Subject subject)
    {
        SubjectOutputDTO subjectOutputDTO = new SubjectOutputDTO();
        subjectOutputDTO.setIdSubject(subject.getIdSubject());
        subjectOutputDTO.setStudents(subject.getStudents());
        subjectOutputDTO.setSignature(subject.getSignature());
        subjectOutputDTO.setComment(subject.getComment());
        subjectOutputDTO.setInitialDate(subject.getInitialDate());
        subjectOutputDTO.setFinishDate(subject.getFinishDate());
        return subjectOutputDTO;
    }

    public static SubjectOutputDTO ofSimple(Subject subject)
    {
        SubjectOutputDTO subjectOutputDTO = new SubjectOutputDTO();
        subjectOutputDTO.setIdSubject(subject.getIdSubject());
        subjectOutputDTO.setSignature(subject.getSignature());
        subjectOutputDTO.setComment(subject.getComment());
        subjectOutputDTO.setInitialDate(subject.getInitialDate());
        subjectOutputDTO.setFinishDate(subject.getFinishDate());
        return subjectOutputDTO;
    }


    public Subject toSubject()
    {
        Subject subject = new Subject();
        subject.setIdSubject(this.getIdSubject());
        subject.setStudents(this.getStudents());
        subject.setSignature(this.getSignature());
        subject.setComment(this.getComment());
        subject.setInitialDate(this.getInitialDate());
        subject.setFinishDate(this.getFinishDate());
        return subject;
    }
}
