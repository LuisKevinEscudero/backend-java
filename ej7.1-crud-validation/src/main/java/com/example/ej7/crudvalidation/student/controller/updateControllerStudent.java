package com.example.ej7.crudvalidation.student.controller;

import com.example.ej7.crudvalidation.student.DTOs.StudentInputDTO;
import com.example.ej7.crudvalidation.student.DTOs.StudentOutputDTO;
import com.example.ej7.crudvalidation.student.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class updateControllerStudent {

    @Autowired
    StudentServiceImp studentServiceImp;

    //creating a put mapping that updates the student detail
    @PutMapping("/updateStudent/{id}")
    public StudentOutputDTO updateStudent(@RequestBody StudentInputDTO student, @PathVariable Integer id) throws Exception
    {
        studentServiceImp.updateStudent(student, id);
        return studentServiceImp.getStudent(id);
    }
}
