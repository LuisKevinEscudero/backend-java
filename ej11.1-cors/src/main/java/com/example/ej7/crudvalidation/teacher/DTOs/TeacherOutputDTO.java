package com.example.ej7.crudvalidation.teacher.DTOs;

import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherOutputDTO {

    private String idTeacher;
    Person person;
    String coments;
    String branch;

    public static TeacherOutputDTO of(Teacher teacher)
    {
        TeacherOutputDTO teacherOutputDTO = new TeacherOutputDTO();
        teacherOutputDTO.setIdTeacher(teacher.getIdTeacher());
        teacherOutputDTO.setPerson(teacher.getPerson());
        teacherOutputDTO.setComents(teacher.getComents());
        teacherOutputDTO.setBranch(teacher.getBranch());
        return teacherOutputDTO;
    }

    public static TeacherOutputDTO ofSimple(Teacher teacher)
    {
        TeacherOutputDTO teacherOutputDTO = new TeacherOutputDTO();
        teacherOutputDTO.setIdTeacher(teacher.getIdTeacher());
        teacherOutputDTO.setComents(teacher.getComents());
        teacherOutputDTO.setBranch(teacher.getBranch());
        return teacherOutputDTO;
    }

    public TeacherOutputDTO(Teacher teacher)
    {
        this.idTeacher = teacher.getIdTeacher();
        this.person = teacher.getPerson();
        this.coments = teacher.getComents();
        this.branch = teacher.getBranch();
    }
}
