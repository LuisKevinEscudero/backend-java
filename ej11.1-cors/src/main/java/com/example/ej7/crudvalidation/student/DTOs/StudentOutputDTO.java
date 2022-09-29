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

    private String idStudent;
    private Person person;
    private Integer numHoursWeek;
    private String coments;
    private TeacherOutputDTO teacher;
    private String branch;
    private List<Subject> studies;

    public static StudentOutputDTO of(Student student) {
        StudentOutputDTO studentOutputDTO = new StudentOutputDTO();
        studentOutputDTO.setIdStudent(student.getIdStudent());
        studentOutputDTO.setPerson(student.getPerson());
        studentOutputDTO.setNumHoursWeek(student.getNumHoursWeek());
        studentOutputDTO.setComents(student.getComents());
        studentOutputDTO.setTeacher(new TeacherOutputDTO(student.getTeacher()));
        studentOutputDTO.setBranch(student.getBranch());
        studentOutputDTO.setStudies(student.getStudies());
        return studentOutputDTO;
    }

    public static StudentOutputDTO ofSimple(Student student) {
        StudentOutputDTO studentOutputDTO = new StudentOutputDTO();
        studentOutputDTO.setIdStudent(student.getIdStudent());
        studentOutputDTO.setNumHoursWeek(student.getNumHoursWeek());
        studentOutputDTO.setComents(student.getComents());
        studentOutputDTO.setBranch(student.getBranch());
        studentOutputDTO.setStudies(student.getStudies());
        return studentOutputDTO;
    }
}
