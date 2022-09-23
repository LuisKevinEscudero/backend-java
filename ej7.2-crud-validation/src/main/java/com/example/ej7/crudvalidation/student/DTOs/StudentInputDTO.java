package com.example.ej7.crudvalidation.student.DTOs;

import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.subject.model.Subject;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDTO {

    private String idStudent;
    private Person person;
    private Integer numHoursWeek;
    private String coments;
    private Teacher teacher;
    private String branch;
    private List<Subject> studies;

    public Student toStudent(){
        Student student = new Student();
        student.setIdStudent(this.idStudent);
        student.setPerson(this.person);
        student.setNumHoursWeek(this.numHoursWeek);
        student.setComents(this.coments);
        student.setTeacher(this.teacher);
        student.setBranch(this.branch);
        student.setStudies(this.studies);
        return student;
    }
}
