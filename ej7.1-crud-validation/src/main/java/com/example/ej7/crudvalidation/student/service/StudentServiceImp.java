package com.example.ej7.crudvalidation.student.service;

import com.example.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.student.DTOs.StudentInputDTO;
import com.example.ej7.crudvalidation.student.DTOs.StudentOutputDTO;
import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void createStudent(StudentInputDTO studentInputDTO) throws Exception
    {

        Student student = studentInputDTO.toStudent();
        if (student.getNumHoursWeek() == null)
        {
            throw new UnprocessableEntityException("El numero de horas semanales no puede ser nulo",422);
        }
        if (student.getNumHoursWeek() < 1)
        {
            throw new UnprocessableEntityException("El numero de horas semanales debe ser mayor que 0",422);
        }
        if(student.getBranch() == null || student.getBranch().isEmpty())
        {
            throw new UnprocessableEntityException("La rama no puede ser nula",422);
        }

        studentRepository.save(student);

    }

    @Override
    public void updateStudent(StudentInputDTO studentInputDTO, Integer id) throws Exception
    {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent())
        {
            Student student = studentOptional.get();
            student.setNumHoursWeek(studentInputDTO.getNumHoursWeek());
            student.setBranch(studentInputDTO.getBranch());
            student.setComents(studentInputDTO.getComents());
            studentRepository.save(student);
        }
        else
        {
            throw new UnprocessableEntityException("El estudiante no existe",422);
        }
    }

    @Override
    public StudentOutputDTO getStudent(Integer id) throws Exception
    {
        return studentRepository
                .findById(id)
                .map(StudentOutputDTO::of)
                .orElseThrow(() -> new UnprocessableEntityException("El estudiante con id " +id+" no existe",422));
    }

    @Override
    public void deleteStudent(Integer id) throws Exception
    {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent())
        {
            Student student = studentOptional.get();
            studentRepository.delete(student);
        }
        else
        {
            throw new UnprocessableEntityException("El estudiante con id " +id+ " no existe",422);
        }
    }


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public StudentOutputDTO getStudentSimple(int id, String ouputType) throws Exception
    {
        return studentRepository
                .findById(id)
                .map(StudentOutputDTO::ofSimple)
                .orElseThrow(() -> new UnprocessableEntityException("El estudiante con id " +id+" no existe",422));
    }
}


