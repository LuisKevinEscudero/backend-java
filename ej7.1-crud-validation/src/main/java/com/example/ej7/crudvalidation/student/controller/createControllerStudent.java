package com.example.ej7.crudvalidation.student.controller;

import com.example.ej7.crudvalidation.student.DTOs.StudentInputDTO;
import com.example.ej7.crudvalidation.student.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class createControllerStudent {

    @Autowired
    StudentServiceImp studentServiceImp;

    @PostMapping("/createStudent")
    private void createStudent(@RequestBody StudentInputDTO student) throws Exception {
        studentServiceImp.createStudent(student);
    }
}
