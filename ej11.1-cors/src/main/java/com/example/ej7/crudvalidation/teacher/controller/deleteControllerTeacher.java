package com.example.ej7.crudvalidation.teacher.controller;

import com.example.ej7.crudvalidation.teacher.service.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class deleteControllerTeacher {
    @Autowired
    TeacherServiceImp teacherServiceImp;

    //creating a delete mapping that deletes a specified teacher
    @DeleteMapping("/deleteTeacher/{idTeacher}")
    public void deleteTeacher(@PathVariable("idTeacher") String idTeacher) throws Exception {
        teacherServiceImp.deleteTeacher(idTeacher);
    }
}
