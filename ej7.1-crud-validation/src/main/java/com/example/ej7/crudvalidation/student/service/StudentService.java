package com.example.ej7.crudvalidation.student.service;

import com.example.ej7.crudvalidation.student.DTOs.StudentInputDTO;
import com.example.ej7.crudvalidation.student.DTOs.StudentOutputDTO;
import com.example.ej7.crudvalidation.student.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentService {
    void createStudent(StudentInputDTO studentInputDTO) throws Exception;
    void updateStudent(StudentInputDTO studentInputDTO, Integer id) throws Exception;
    StudentOutputDTO getStudent(Integer id) throws Exception;
    void deleteStudent(Integer id) throws Exception;

    List<Student> findAllStudents() throws Exception;
    StudentOutputDTO getStudentSimple(int id, String ouputType) throws Exception;


    }
