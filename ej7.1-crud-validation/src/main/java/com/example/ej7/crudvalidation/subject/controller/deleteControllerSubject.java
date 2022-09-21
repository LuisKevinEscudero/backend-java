package com.example.ej7.crudvalidation.subject.controller;

import com.example.ej7.crudvalidation.subject.service.SubjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class deleteControllerSubject {

    @Autowired
    SubjectServiceImp subjectServiceImp;

    //creating a delete mapping that deletes a specified subject
    @DeleteMapping("/deleteSubject/{idSubject}")
    public void deleteSubject(@PathVariable("idSubject") String idSubject) throws Exception {
        subjectServiceImp.deleteSubject(idSubject);
    }
}
