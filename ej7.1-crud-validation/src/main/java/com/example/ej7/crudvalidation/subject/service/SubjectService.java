package com.example.ej7.crudvalidation.subject.service;

import com.example.ej7.crudvalidation.subject.DTOs.SubjectInputDTO;
import com.example.ej7.crudvalidation.subject.DTOs.SubjectOutputDTO;
import com.example.ej7.crudvalidation.subject.model.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SubjectService {

    void createSubject(SubjectInputDTO subjectInputDTO) throws Exception;
    void updateSubject(SubjectInputDTO subjectInputDTO, String idSubject) throws Exception;

    SubjectOutputDTO getSubject(String idSubject) throws Exception;
    void deleteSubject(String idSubject) throws Exception;
    List<Subject> findAll();
    SubjectOutputDTO getSubjectSimple(String idSubject, String ouputType) throws Exception;

    void assignSubject(String idSubject, String idStudent) throws Exception;

    void assignSubjects(String idStudent, List<SubjectInputDTO> subjects) throws Exception;

    void desAssingSubjects(String idStudent, @RequestBody List<SubjectInputDTO> subjects) throws Exception;


}
