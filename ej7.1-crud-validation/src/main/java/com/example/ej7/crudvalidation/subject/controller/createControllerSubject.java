package com.example.ej7.crudvalidation.subject.controller;

import com.example.ej7.crudvalidation.student.DTOs.StudentInputDTO;
import com.example.ej7.crudvalidation.student.DTOs.StudentOutputDTO;
import com.example.ej7.crudvalidation.student.service.StudentServiceImp;
import com.example.ej7.crudvalidation.subject.DTOs.SubjectInputDTO;
import com.example.ej7.crudvalidation.subject.DTOs.SubjectOutputDTO;
import com.example.ej7.crudvalidation.subject.model.Subject;
import com.example.ej7.crudvalidation.subject.service.SubjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class createControllerSubject {

    @Autowired
    SubjectServiceImp subjectServiceImp;

    @Autowired
    StudentServiceImp studentServiceImp;

    @PostMapping("/createSubject")
    public void createSubject(@RequestBody SubjectInputDTO subject) throws Exception {
        subjectServiceImp.createSubject(subject);
    }

    @PostMapping("/assignSubject/{subjectId}/{studentId}")
    public void assignSubject(@PathVariable Integer subjectId, @PathVariable Integer studentId) throws Exception {
        subjectServiceImp.assignSubject(subjectId, studentId);
    }
}
