package com.example.ej7.crudvalidation.teacher.controller;

import com.example.ej7.crudvalidation.teacher.DTOs.TeacherInputDTO;
import com.example.ej7.crudvalidation.teacher.DTOs.TeacherOutputDTO;
import com.example.ej7.crudvalidation.teacher.service.TeacherServiceImp;
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
    @PutMapping("/updateTeacher/{idTeacher}")
    public TeacherOutputDTO updateTeacher(@RequestBody TeacherInputDTO teacher, @PathVariable String idTeacher) throws Exception
    {
        teacherServiceImp.updateTeacher(teacher, idTeacher);
        return teacherServiceImp.getTeacher(idTeacher);
    }
}
