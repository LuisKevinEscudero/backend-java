package com.example.ej7.crudvalidation.teacher.DTOs;

import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public TeacherOutputDTO(Teacher teacher)
    {
        this.id = teacher.getId();
        this.person = teacher.getPerson();
        this.coments = teacher.getComents();
        this.branch = teacher.getBranch();
    }
}
