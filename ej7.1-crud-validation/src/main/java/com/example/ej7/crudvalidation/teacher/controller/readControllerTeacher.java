package com.example.ej7.crudvalidation.teacher.controller;

import com.example.ej7.crudvalidation.teacher.DTOs.TeacherOutputDTO;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import com.example.ej7.crudvalidation.teacher.service.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class readControllerTeacher {

    @Autowired
    TeacherServiceImp teacherServiceImp;

    //creating a get mapping that retrieves all the teachers detail from the database
    @GetMapping("/getAllTeachers")
    private List<Teacher> getAllTeachers()
    {
        return teacherServiceImp.findAll();
    }

    //creating a get mapping that retrieves the detail of a specific teacher
    @GetMapping("/getTeacher/{teacherid}")
    private TeacherOutputDTO getTeacher(@PathVariable("teacherid") int teacherid, @RequestParam String ouputType) throws Exception
    {
        String tipo= "full";
        if (ouputType.equals(tipo))
        {
            return teacherServiceImp.getTeacher(teacherid);

        }
        else
        {
            return teacherServiceImp.getTeacherSimple(teacherid, ouputType);
        }
    }

}
