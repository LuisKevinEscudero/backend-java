package com.example.ej7.crudvalidation.subject.service;

import com.example.ej7.crudvalidation.subject.DTOs.SubjectInputDTO;
import com.example.ej7.crudvalidation.subject.DTOs.SubjectOutputDTO;
import com.example.ej7.crudvalidation.subject.model.Subject;

import java.util.List;

public interface SubjectService {

    void createSubject(SubjectInputDTO subjectInputDTO) throws Exception;
    void updateSubject(SubjectInputDTO subjectInputDTO, Integer id) throws Exception;

    SubjectOutputDTO getSubject(Integer id) throws Exception;
    void deleteSubject(Integer id) throws Exception;
    List<Subject> findAll();
    SubjectOutputDTO getSubjectSimple(int id, String ouputType) throws Exception;

}
