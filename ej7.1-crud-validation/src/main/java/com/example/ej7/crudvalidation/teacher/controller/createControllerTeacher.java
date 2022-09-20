package com.example.ej7.crudvalidation.teacher.controller;

import com.example.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.student.service.StudentService;
import com.example.ej7.crudvalidation.teacher.DTOs.TeacherInputDTO;
import com.example.ej7.crudvalidation.teacher.service.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class createControllerTeacher {

    @Autowired
    TeacherServiceImp teacherServiceImp;

    @Autowired
    StudentService studentService;

    @PostMapping("/createTeacher")
    public void createTeacher(@RequestBody TeacherInputDTO teacher) throws Exception
    {
        List<Student> students = studentService.findAllStudents();

        if (students != null)
        {
            for (Student s : students)
            {
                if (s.getPerson().getIdPerson() == teacher.getPerson().getIdPerson())
                {
                    throw new UnprocessableEntityException("Ya existe un estudiante con ese id",422);
                }
            }
        }

        teacherServiceImp.createTeacher(teacher);
    }
}
