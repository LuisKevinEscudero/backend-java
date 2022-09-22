package com.example.ej7.crudvalidation.teacher.service;

import com.example.ej7.crudvalidation.exceptions.EntityNotFoundException;
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
        if(teacher.getBranch().length() < 3)
        {
            throw new UnprocessableEntityException("La rama debe tener al menos 3 caracteres",422);
        }
        if(teacherRepository.findById(teacher.getPerson().getIdPerson()).isPresent())
        {
            throw new UnprocessableEntityException("Ya existe un profesor con ese id",422);
        }

        teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacher(TeacherInputDTO teacherInputDTO, String idTeacher) throws Exception
    {
        Optional<Teacher> teacherOptional = teacherRepository.findById(idTeacher);
        if (teacherOptional.isPresent())
        {
            Teacher teacher = teacherOptional.get();
            teacher.setBranch(teacherInputDTO.getBranch());
            teacher.setComents(teacherInputDTO.getComents());
            teacherRepository.save(teacher);
        }
        else
        {
            throw new EntityNotFoundException("El profesor no existe",404);
        }
    }

    @Override
    public TeacherOutputDTO getTeacher(String idTeacher) throws Exception
    {
        return teacherRepository
                .findById(idTeacher)
                .map(TeacherOutputDTO::of)
                .orElseThrow(() -> new EntityNotFoundException("El profesor no existe",404));
    }

    @Override
    public void deleteTeacher(String idTeacher) throws Exception
    {
        Optional<Teacher> teacherOptional = teacherRepository.findById(idTeacher);
        if (teacherOptional.isPresent())
        {
            teacherRepository.delete(teacherOptional.get());
        }
        else
        {
            throw new EntityNotFoundException("El profesor no existe",404);
        }
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public TeacherOutputDTO getTeacherSimple(String idTeacher, String ouputType) throws Exception {
        return teacherRepository
                .findById(idTeacher)
                .map(TeacherOutputDTO::ofSimple)
                .orElseThrow(() -> new EntityNotFoundException("El profesor no existe",404));

    }


}
