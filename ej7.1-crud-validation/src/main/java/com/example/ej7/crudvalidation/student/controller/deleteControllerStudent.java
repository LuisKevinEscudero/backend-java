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
    @DeleteMapping("/deleteStudent/{studentid}")
    public void deleteStudent(@PathVariable("studentid") int studentid) throws Exception {
        studentServiceImp.deleteStudent(studentid);
    }
}
