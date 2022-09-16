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
public class SubjectOutputDTO {

    private Integer id;
    //private Teacher teacher;
    private Student student;
    private String asignatura;
    private String comment;
    private Date initial_date;
    private Date finish_date;

    public static SubjectOutputDTO of(Subject subject)
    {
        SubjectOutputDTO subjectOutputDTO = new SubjectOutputDTO();
        subjectOutputDTO.setId(subject.getId());
        //subjectOutputDTO.setTeacher(subject.getTeacher());
        subjectOutputDTO.setStudent(subject.getStudent());
        subjectOutputDTO.setAsignatura(subject.getAsignatura());
        subjectOutputDTO.setComment(subject.getComment());
        subjectOutputDTO.setInitial_date(subject.getInitial_date());
        subjectOutputDTO.setFinish_date(subject.getFinish_date());
        return subjectOutputDTO;
    }

    public static SubjectOutputDTO ofSimple(Subject subject)
    {
        SubjectOutputDTO subjectOutputDTO = new SubjectOutputDTO();
        subjectOutputDTO.setId(subject.getId());
        subjectOutputDTO.setAsignatura(subject.getAsignatura());
        subjectOutputDTO.setComment(subject.getComment());
        subjectOutputDTO.setInitial_date(subject.getInitial_date());
        subjectOutputDTO.setFinish_date(subject.getFinish_date());
        return subjectOutputDTO;
    }

}
