package com.example.ej7.crudvalidation.student.DTOs;

import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.student.model.Student;
import lombok.Data;

@Data
public class StudentOutputDTOSimple {

    private Integer id;
    private Person person;
    private Integer numHoursWeek;
    private String coments;
    //private Profesor profesor;
    private String branch;
    //private List<Alumnos_Estudios> estudios;

    public static StudentOutputDTO of(Student student) {
        StudentOutputDTO studentOutputDTO = new StudentOutputDTO();
        studentOutputDTO.setId(student.getId());
        studentOutputDTO.setNumHoursWeek(student.getNumHoursWeek());
        studentOutputDTO.setComents(student.getComents());
        //studentOutputDTO.setProfesor(student.getProfesor());
        studentOutputDTO.setBranch(student.getBranch());
        //studentOutputDTO.setEstudios(student.getEstudios());
        return studentOutputDTO;
    }
}