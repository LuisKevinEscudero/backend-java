package com.example.ej7.crudvalidation.subject.service;

import com.example.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.example.ej7.crudvalidation.student.DTOs.StudentInputDTO;
import com.example.ej7.crudvalidation.student.DTOs.StudentOutputDTO;
import com.example.ej7.crudvalidation.student.model.Student;
import com.example.ej7.crudvalidation.student.repository.StudentRepository;
import com.example.ej7.crudvalidation.subject.DTOs.SubjectInputDTO;
import com.example.ej7.crudvalidation.subject.DTOs.SubjectOutputDTO;
import com.example.ej7.crudvalidation.subject.model.Subject;
import com.example.ej7.crudvalidation.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class SubjectServiceImp implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;


    @Override
    public void createSubject(SubjectInputDTO subjectInputDTO) throws Exception {
        Subject subject = subjectInputDTO.toSubject();

        subject.setInitial_date(new Date());
        if(subject.getAsignatura()==null){
            throw new UnprocessableEntityException("La asignatura no puede ser nula",422);
        }
        if (subject.getAsignatura().length() < 3) {
            throw new UnprocessableEntityException("La asignatura debe tener al menos 3 caracteres",422);
        }

        if(subject.getInitial_date()==null){
            throw new UnprocessableEntityException("La fecha no puede ser nula",422);
        }
        if(subject.getInitial_date().after(new Date())){
            throw new UnprocessableEntityException("La fecha de inicio no puede ser posterior a la fecha actual",422);
        }

        subjectRepository.save(subject);
    }

    @Override
    public void updateSubject(SubjectInputDTO subjectInputDTO, Integer id) throws Exception {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        if (subjectOptional.isPresent())
        {
            Subject subject = subjectOptional.get();
            subject.setAsignatura(subjectInputDTO.getAsignatura());
            subject.setComment(subjectInputDTO.getComment());
            subject.setFinish_date(subjectInputDTO.getFinish_date());
            subject.setInitial_date(subjectInputDTO.getInitial_date());
           // subject.setStudent(subjectInputDTO.getStudent());
            subjectRepository.save(subject);
        }
        else
        {
            throw new UnprocessableEntityException("La asignatura no existe",422);
        }
    }

    @Override
    public SubjectOutputDTO getSubject(Integer id) throws Exception {
        return subjectRepository
                .findById(id)
                .map(SubjectOutputDTO::of)
                .orElseThrow(() -> new UnprocessableEntityException("La asignatura no existe",422));
    }

    @Override
    public void deleteSubject(Integer id) throws Exception {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        if (subjectOptional.isPresent())
        {
            Subject subject = subjectOptional.get();
            subjectRepository.delete(subject);
        }
        else
        {
            throw new UnprocessableEntityException("La asignatura no existe",422);
        }
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public SubjectOutputDTO getSubjectSimple(int id, String ouputType) throws Exception {
        return subjectRepository
                .findById(id)
                .map(SubjectOutputDTO::ofSimple)
                .orElseThrow(() -> new UnprocessableEntityException("La asignatura no existe",422));
    }


    public void assignSubject(int id_subject, int id_student) throws Exception
    {
        Student student = new Student();
        student= studentRepository.findById(id_student).get();

        Subject subject = new Subject();
        subject= subjectRepository.findById(id_subject).get();

        List<Student> students = null;
        students.add(student);

        subject.setStudents(students);

        subjectRepository.save(subject);
    }

}
