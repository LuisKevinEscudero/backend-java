package com.example.ej7.crudvalidation.student.controller;

import com.example.ej7.crudvalidation.student.DTOs.StudentOutputDTO;
import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.student.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class readControllerStudent {

    @Autowired
    StudentServiceImp studentServiceImp;

    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/getAllStudents")
    private List<Student> getAllStudents()
    {
        return studentServiceImp.findAll();
    }

    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/getStudent/{studentid}")
    private StudentOutputDTO getStudent(@PathVariable("studentid") int studentid) throws Exception {
        return studentServiceImp.getStudent(studentid);
    }

    @GetMapping("/getStudentByName/{name}")
    private List<StudentOutputDTO> getStudentByName(@PathVariable("name") String name) throws Exception
    {
        return studentServiceImp.findByName(name);
    }
}
