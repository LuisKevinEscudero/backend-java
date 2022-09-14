package com.example.ej7.crudvalidation.profesor.controller;

import com.example.ej7.crudvalidation.profesor.DTOs.TeacherInputDTO;
import com.example.ej7.crudvalidation.profesor.service.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class createControllerTeacher {

    @Autowired
    TeacherServiceImp teacherServiceImp;

    @PostMapping("/createTeacher")
    private void createTeacher(@RequestBody TeacherInputDTO teacher) throws Exception
    {
        teacherServiceImp.createTeacher(teacher);
    }
}
