package com.example.ej7.crudvalidation.subject.service;

import com.example.ej7.crudvalidation.subject.DTOs.SubjectInputDTO;
import com.example.ej7.crudvalidation.subject.DTOs.SubjectOutputDTO;
import com.example.ej7.crudvalidation.subject.model.Subject;

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

}
