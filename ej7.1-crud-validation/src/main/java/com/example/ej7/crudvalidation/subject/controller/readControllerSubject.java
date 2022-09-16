package com.example.ej7.crudvalidation.subject.controller;

import com.example.ej7.crudvalidation.subject.DTOs.SubjectOutputDTO;
import com.example.ej7.crudvalidation.subject.model.Subject;
import com.example.ej7.crudvalidation.subject.service.SubjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class readControllerSubject {

    @Autowired
    SubjectServiceImp subjectServiceImp;

    //creating a get mapping that retrieves all the subjects detail from the database
    @GetMapping("/getAllSubjects")
    public List<Subject> getAllSubjects()
    {
        return subjectServiceImp.findAll();
    }

    //creating a get mapping that retrieves the detail of a specific subject
    @GetMapping("/getSubject/{subjectid}")
    public SubjectOutputDTO getSubject(@PathVariable("subjectid") int subjectid, @RequestParam String ouputType) throws Exception
    {
        String tipo= "full";
        if (ouputType.equals(tipo))
        {
            return subjectServiceImp.getSubject(subjectid);

        }
        else
        {
            return subjectServiceImp.getSubjectSimple(subjectid, ouputType);
        }
    }
}
