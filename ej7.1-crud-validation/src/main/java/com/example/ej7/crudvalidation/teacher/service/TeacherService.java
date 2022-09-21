package com.example.ej7.crudvalidation.teacher.service;

import com.example.ej7.crudvalidation.teacher.DTOs.TeacherInputDTO;
import com.example.ej7.crudvalidation.teacher.DTOs.TeacherOutputDTO;
import com.example.ej7.crudvalidation.teacher.model.Teacher;

import java.util.List;

public interface TeacherService {
    void createTeacher(TeacherInputDTO teacherInputDTO) throws Exception;
    void updateTeacher(TeacherInputDTO teacherInputDTO, String idTeacher) throws Exception;
    TeacherOutputDTO getTeacher(String idTeacher) throws Exception;
    void deleteTeacher(String idTeacher) throws Exception;
    List<Teacher> findAll();
    TeacherOutputDTO getTeacherSimple(String idTeacher, String ouputType) throws Exception;
}
