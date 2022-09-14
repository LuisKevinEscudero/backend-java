package com.example.ej7.crudvalidation.profesor.DTOs;

import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.profesor.model.Teacher;
import lombok.Data;

@Data
public class TeacherOutputDTO {

    private Integer id;
    Person person;
    String coments;
    String branch;

    public static TeacherOutputDTO of(Teacher teacher)
    {
        TeacherOutputDTO teacherOutputDTO = new TeacherOutputDTO();
        teacherOutputDTO.setId(teacher.getId());
        teacherOutputDTO.setPerson(teacher.getPerson());
        teacherOutputDTO.setComents(teacher.getComents());
        teacherOutputDTO.setBranch(teacher.getBranch());
        return teacherOutputDTO;
    }

    public static TeacherOutputDTO ofSimple(Teacher teacher)
    {
        TeacherOutputDTO teacherOutputDTO = new TeacherOutputDTO();
        teacherOutputDTO.setId(teacher.getId());
        teacherOutputDTO.setComents(teacher.getComents());
        teacherOutputDTO.setBranch(teacher.getBranch());
        return teacherOutputDTO;
    }
}
