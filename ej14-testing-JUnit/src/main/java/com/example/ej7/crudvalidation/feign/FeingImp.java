package com.example.ej7.crudvalidation.feign;

import com.example.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.example.ej7.crudvalidation.person.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.teacher.DTOs.TeacherOutputDTO;
import com.example.ej7.crudvalidation.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeingImp implements IFeignServer {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public TeacherOutputDTO getTeacher(String idTeacher) {
        return teacherRepository
                .findById(idTeacher)
                .map(TeacherOutputDTO::of)
                .orElseThrow(() -> new EntityNotFoundException("El profesor no existe",404));
    }

}
