package com.example.ej7.crudvalidation.student.controller;

import com.example.ej7.crudvalidation.student.DTOs.StudentOutputDTO;
import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.student.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class readControllerStudent {

    @Autowired
    StudentServiceImp studentServiceImp;

    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents()
    {
        return studentServiceImp.findAllStudents();
    }

    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/getStudent/{studentid}")
    public StudentOutputDTO getStudent(@PathVariable("studentid") int studentid, @RequestParam String ouputType) throws Exception
    {
        String tipo= "full";
        if (ouputType.equals(tipo))
        {
            return studentServiceImp.getStudent(studentid);

        }
        else
        {
            return studentServiceImp.getStudentSimple(studentid, ouputType);
        }

    }


}
