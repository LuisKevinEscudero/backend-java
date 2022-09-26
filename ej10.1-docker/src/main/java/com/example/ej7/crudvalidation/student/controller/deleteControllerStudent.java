package com.example.ej7.crudvalidation.student.controller;

import com.example.ej7.crudvalidation.student.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class deleteControllerStudent {

    @Autowired
    StudentServiceImp studentServiceImp;

    //creating a delete mapping that deletes a specified student
    @DeleteMapping("/deleteStudent/{idStudent}")
    public void deleteStudent(@PathVariable("idStudent") String idStudent) throws Exception {
        studentServiceImp.deleteStudent(idStudent);
    }
}
