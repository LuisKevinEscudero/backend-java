package com.example.ej7.crudvalidation.student.service;

import com.example.ej7.crudvalidation.student.DTOs.StudentInputDTO;
import com.example.ej7.crudvalidation.student.DTOs.StudentOutputDTO;
import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.subject.model.Subject;


import java.util.List;

public interface StudentService {
    void createStudent(StudentInputDTO studentInputDTO) throws Exception;
    void updateStudent(StudentInputDTO studentInputDTO, String idStudent) throws Exception;
    StudentOutputDTO getStudent(String idStudent) throws Exception;
    void deleteStudent(String idStudent) throws Exception;
    List<Student> findAllStudents() throws Exception;
    StudentOutputDTO getStudentSimple(String idStudent, String ouputType) throws Exception;
    List<Subject> getStudentSubject(String idStudent);
}
