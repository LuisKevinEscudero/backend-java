package com.example.ej7.crudvalidation.subject.controller;

import com.example.ej7.crudvalidation.subject.DTOs.SubjectInputDTO;
import com.example.ej7.crudvalidation.subject.service.SubjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class createControllerSubject {

    @Autowired
    SubjectServiceImp subjectServiceImp;

    @PostMapping("/createSubject")
    public void createSubject(@RequestBody SubjectInputDTO subject) throws Exception {
        subjectServiceImp.createSubject(subject);
    }
}
