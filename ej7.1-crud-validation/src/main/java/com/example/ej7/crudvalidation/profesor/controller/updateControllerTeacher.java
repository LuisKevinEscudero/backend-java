package com.example.ej7.crudvalidation.profesor.controller;

import com.example.ej7.crudvalidation.profesor.DTOs.TeacherInputDTO;
import com.example.ej7.crudvalidation.profesor.DTOs.TeacherOutputDTO;
import com.example.ej7.crudvalidation.profesor.service.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class updateControllerTeacher {

    @Autowired
    TeacherServiceImp teacherServiceImp;

    //creating a put mapping that updates the teacher detail
    @PutMapping("/updateTeacher/{id}")
    private TeacherOutputDTO updateTeacher(@RequestBody TeacherInputDTO teacher, @PathVariable Integer id) throws Exception
    {
        teacherServiceImp.updateTeacher(teacher, id);
        return teacherServiceImp.getTeacher(id);
    }
}
