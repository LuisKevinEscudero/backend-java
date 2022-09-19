package com.example.ej7.crudvalidation.student.DTOs;

import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.subject.model.Subject;
import com.example.ej7.crudvalidation.teacher.DTOs.TeacherOutputDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDTO {

    private Integer id;
    private Person person;
    private Integer numHoursWeek;
    private String coments;
    private TeacherOutputDTO teacher;
    private String branch;
    private List<Subject> estudios;

    public static StudentOutputDTO of(Student student) {
        StudentOutputDTO studentOutputDTO = new StudentOutputDTO();
        studentOutputDTO.setId(student.getId());
        studentOutputDTO.setPerson(student.getPerson());
        studentOutputDTO.setNumHoursWeek(student.getNumHoursWeek());
        studentOutputDTO.setComents(student.getComents());
        studentOutputDTO.setTeacher(new TeacherOutputDTO(student.getTeacher()));
        studentOutputDTO.setBranch(student.getBranch());
        studentOutputDTO.setEstudios(student.getEstudios());
        return studentOutputDTO;
    }

    public static StudentOutputDTO ofSimple(Student student) {
        StudentOutputDTO studentOutputDTO = new StudentOutputDTO();
        studentOutputDTO.setId(student.getId());
        studentOutputDTO.setNumHoursWeek(student.getNumHoursWeek());
        studentOutputDTO.setComents(student.getComents());
        studentOutputDTO.setBranch(student.getBranch());
        studentOutputDTO.setEstudios(student.getEstudios());
        return studentOutputDTO;
    }
}
