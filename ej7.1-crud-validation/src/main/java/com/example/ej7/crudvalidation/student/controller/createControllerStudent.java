package com.example.ej7.crudvalidation.student.controller;

import com.example.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.example.ej7.crudvalidation.student.DTOs.StudentInputDTO;
import com.example.ej7.crudvalidation.student.service.StudentServiceImp;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import com.example.ej7.crudvalidation.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class createControllerStudent {

    @Autowired
    StudentServiceImp studentServiceImp;

    @Autowired
    TeacherService teacherService;

    @PostMapping("/createStudent")
    public void createStudent(@RequestBody StudentInputDTO student) throws Exception
    {
        List<Teacher> teachers = teacherService.findAll();

        if (teachers != null)
        {
            for (Teacher t : teachers)
            {
                if (t.getPerson().getId() == student.getPerson().getId())
                {
                    throw new UnprocessableEntityException("Ya existe un profesor con ese id",422);
                }
            }
        }

        studentServiceImp.createStudent(student);
    }
}
