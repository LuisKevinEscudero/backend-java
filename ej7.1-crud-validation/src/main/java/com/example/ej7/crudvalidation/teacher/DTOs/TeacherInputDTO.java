package com.example.ej7.crudvalidation.teacher.DTOs;

import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import lombok.Data;

@Data
public class TeacherInputDTO {
    private Integer id;
    Person person;
    String coments;
    String branch;

    public Teacher toTeacher(){
        Teacher teacher = new Teacher();
        teacher.setId(this.id);
        teacher.setPerson(this.person);
        teacher.setComents(this.coments);
        teacher.setBranch(this.branch);
        return teacher;
    }
}
