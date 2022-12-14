package com.example.ej7.crudvalidation.subject.controller;

import com.example.ej7.crudvalidation.subject.DTOs.SubjectInputDTO;
import com.example.ej7.crudvalidation.subject.DTOs.SubjectOutputDTO;
import com.example.ej7.crudvalidation.subject.service.SubjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class updateControllerSubject {

    @Autowired
    SubjectServiceImp subjectServiceImp;

    //creating a put mapping that updates the subject detail
    @PutMapping("/updateSubject/{idSubject}")
    public SubjectOutputDTO updateSubject(@RequestBody SubjectInputDTO subject, @PathVariable String idSubject) throws Exception
    {
        subjectServiceImp.updateSubject(subject, idSubject);
        return subjectServiceImp.getSubject(idSubject);
    }
}
