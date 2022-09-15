package com.example.ej7.crudvalidation.student.DTOs;

import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class StudentInputDTO {

    private Integer id;
    private Person person;
    private Integer numHoursWeek;
    private String coments;
    private Teacher teacher;
    private String branch;
    //private List<Alumnos_Estudios> estudios;

    public Student toStudent(){
        Student student = new Student();
        student.setId(this.id);
        student.setPerson(this.person);
        student.setNumHoursWeek(this.numHoursWeek);
        student.setComents(this.coments);
        student.setTeacher(this.teacher);
        student.setBranch(this.branch);
        //student.setEstudios(this.estudios);
        return student;
    }
}
