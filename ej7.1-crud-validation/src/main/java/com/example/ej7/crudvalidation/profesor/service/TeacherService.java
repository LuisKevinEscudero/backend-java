package com.example.ej7.crudvalidation.profesor.service;

import com.example.ej7.crudvalidation.profesor.DTOs.TeacherInputDTO;
import com.example.ej7.crudvalidation.profesor.DTOs.TeacherOutputDTO;
import com.example.ej7.crudvalidation.profesor.model.Teacher;

import java.util.List;

public interface TeacherService {
    void createTeacher(TeacherInputDTO teacherInputDTO) throws Exception;
    void updateTeacher(TeacherInputDTO teacherInputDTO, Integer id) throws Exception;
    TeacherOutputDTO getTeacher(Integer id) throws Exception;
    void deleteTeacher(Integer id) throws Exception;
    List<Teacher> findAll();
    TeacherOutputDTO getTeacherSimple(int id, String ouputType) throws Exception;
}
