package com.example.ej7.crudvalidation.teacher.service;

import com.example.ej7.crudvalidation.teacher.DTOs.TeacherInputDTO;
import com.example.ej7.crudvalidation.teacher.DTOs.TeacherOutputDTO;
import com.example.ej7.crudvalidation.teacher.model.Teacher;

import java.util.List;

public interface TeacherService {
    void createTeacher(TeacherInputDTO teacherInputDTO) throws Exception;
    void updateTeacher(TeacherInputDTO teacherInputDTO, Integer id) throws Exception;
    TeacherOutputDTO getTeacher(Integer id) throws Exception;
    void deleteTeacher(Integer id) throws Exception;
    List<Teacher> findAll();
    TeacherOutputDTO getTeacherSimple(int id, String ouputType) throws Exception;
}
