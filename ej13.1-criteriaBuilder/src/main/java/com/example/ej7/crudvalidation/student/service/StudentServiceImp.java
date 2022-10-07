package com.example.ej7.crudvalidation.student.service;

import com.example.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.example.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.person.repository.PersonRepository;
import com.example.ej7.crudvalidation.student.DTOs.StudentInputDTO;
import com.example.ej7.crudvalidation.student.DTOs.StudentOutputDTO;
import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.student.repository.StudentRepository;
import com.example.ej7.crudvalidation.subject.model.Subject;
import com.example.ej7.crudvalidation.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;


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
        if (student.getBranch().length() < 3)
        {
            throw new UnprocessableEntityException("La rama debe tener al menos 3 caracteres",422);
        }
        if (student.getPerson() == null)
        {
            throw new UnprocessableEntityException("La persona no puede ser nula",422);
        }
        if (student.getPerson().getIdPerson() == null || student.getPerson().getIdPerson().isEmpty())
        {
            throw new UnprocessableEntityException("El id de la persona no puede ser nulo",422);
        }

        if (studentRepository.findById(student.getPerson().getIdPerson()).isPresent())
        {
            throw new EntityNotFoundException("Ya existe un estudiante con ese id",404);
        }

        studentRepository.save(student);
    }

    @Override
    public void updateStudent(StudentInputDTO studentInputDTO, String idStudent) throws Exception
    {
        Optional<Student> studentOptional = studentRepository.findById(idStudent);
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
            throw new EntityNotFoundException("El estudiante no existe",404);
        }
    }

    @Override
    public StudentOutputDTO getStudent(String idStudent) throws Exception
    {
        return studentRepository
                .findById(idStudent)
                .map(StudentOutputDTO::of)
                .orElseThrow(() -> new EntityNotFoundException("El estudiante con id " +idStudent+" no existe",404));
    }

    @Override
    public void deleteStudent(String idStudent) throws Exception
    {
        Optional<Student> studentOptional = studentRepository.findById(idStudent);
        if (studentOptional.isPresent())
        {
            Student student = studentOptional.get();
            studentRepository.delete(student);
        }
        else
        {
            throw new EntityNotFoundException("El estudiante con id " +idStudent+ " no existe",404);
        }
    }



    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentOutputDTO getStudentSimple(String idStudent, String ouputType) throws Exception
    {
        return studentRepository
                .findById(idStudent)
                .map(StudentOutputDTO::ofSimple)
                .orElseThrow(() -> new EntityNotFoundException("El estudiante con id " +idStudent+" no existe",404));
    }

    @Override
    public List<Subject> getStudentSubject(String idStudent)
    {
        Student student= studentRepository
                .findById(idStudent)
                .orElseThrow(() -> new EntityNotFoundException("El estudiante con id " +idStudent+" no existe",404));

        return student.getStudies();

    }
}


