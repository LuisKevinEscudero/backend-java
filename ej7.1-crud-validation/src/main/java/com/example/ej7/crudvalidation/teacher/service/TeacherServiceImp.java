package com.example.ej7.crudvalidation.teacher.service;

import com.example.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.example.ej7.crudvalidation.teacher.DTOs.TeacherInputDTO;
import com.example.ej7.crudvalidation.teacher.DTOs.TeacherOutputDTO;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import com.example.ej7.crudvalidation.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeacherServiceImp implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;


    @Override
    public void createTeacher(TeacherInputDTO teacherInputDTO) throws Exception
    {
        Teacher teacher = teacherInputDTO.toTeacher();
        if(teacher.getBranch() == null || teacher.getBranch().isEmpty())
        {
            throw new UnprocessableEntityException("La rama no puede ser nula",422);
        }



        teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacher(TeacherInputDTO teacherInputDTO, Integer id) throws Exception
    {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent())
        {
            Teacher teacher = teacherOptional.get();
            teacher.setBranch(teacherInputDTO.getBranch());
            teacher.setComents(teacherInputDTO.getComents());
            teacherRepository.save(teacher);
        }
        else
        {
            throw new UnprocessableEntityException("El profesor no existe",422);
        }
    }

    @Override
    public TeacherOutputDTO getTeacher(Integer id) throws Exception
    {
        return teacherRepository
                .findById(id)
                .map(TeacherOutputDTO::of)
                .orElseThrow(() -> new UnprocessableEntityException("El profesor no existe",422));
    }

    @Override
    public void deleteTeacher(Integer id) throws Exception
    {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent())
        {
            teacherRepository.delete(teacherOptional.get());
        }
        else
        {
            throw new UnprocessableEntityException("El profesor no existe",422);
        }
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public TeacherOutputDTO getTeacherSimple(int id, String ouputType) throws Exception {
        return teacherRepository
                .findById(id)
                .map(TeacherOutputDTO::ofSimple)
                .orElseThrow(() -> new UnprocessableEntityException("El profesor no existe",422));

    }
}
