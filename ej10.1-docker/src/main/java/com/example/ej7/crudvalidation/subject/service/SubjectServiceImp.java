package com.example.ej7.crudvalidation.subject.service;

import com.example.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.example.ej7.crudvalidation.exceptions.UnprocessableEntityException;
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

        subject.setInitialDate(new Date());

        if(subject.getSignature()==null){
            throw new UnprocessableEntityException("La asignatura no puede ser nula",422);
        }
        if (subject.getSignature().length() < 3) {
            throw new UnprocessableEntityException("La asignatura debe tener al menos 3 caracteres",422);
        }

        if(subject.getInitialDate()==null){
            throw new UnprocessableEntityException("La fecha no puede ser nula",422);
        }
        if(subject.getInitialDate().after(new Date())){
            throw new UnprocessableEntityException("La fecha de inicio no puede ser posterior a la fecha actual",422);
        }

        subjectRepository.save(subject);
    }

    @Override
    public void updateSubject(SubjectInputDTO subjectInputDTO, String idSubject) throws Exception {
        Optional<Subject> subjectOptional = subjectRepository.findById(idSubject);
        if (subjectOptional.isPresent())
        {
            Subject subject = subjectOptional.get();
            subject.setSignature(subjectInputDTO.getSignature());
            subject.setComment(subjectInputDTO.getComment());
            subject.setFinishDate(subjectInputDTO.getFinishDate());
            subject.setInitialDate(subjectInputDTO.getInitialDate());
            subject.setStudents(subjectInputDTO.getStudents());
            subjectRepository.save(subject);
        }
        else
        {
            throw new EntityNotFoundException("La asignatura no existe",404);
        }
    }

    @Override
    public SubjectOutputDTO getSubject(String idSubject) throws Exception {
        return subjectRepository
                .findById(idSubject)
                .map(SubjectOutputDTO::of)
                .orElseThrow(() -> new EntityNotFoundException("La asignatura no existe",404));
    }

    @Override
    public void deleteSubject(String idSubject) throws Exception {
        Optional<Subject> subjectOptional = subjectRepository.findById(idSubject);
        if (subjectOptional.isPresent())
        {
            Subject subject = subjectOptional.get();

            if (subject.getStudents().size() > 0)
            {
                throw new UnprocessableEntityException("La asignatura tiene alumnos matriculados",422);
            }
            subjectRepository.delete(subject);
        }
        else
        {
            throw new EntityNotFoundException("La asignatura no existe",404);
        }
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public SubjectOutputDTO getSubjectSimple(String idSubject, String ouputType) throws Exception {
        return subjectRepository
                .findById(idSubject)
                .map(SubjectOutputDTO::ofSimple)
                .orElseThrow(() -> new EntityNotFoundException("La asignatura no existe",404));
    }


    public void assignSubject(String idSubject, String idStudent) throws Exception
    {
        Student student = studentRepository
                .findById(idStudent)
                .orElseThrow(() -> new EntityNotFoundException("estudiante no encontrado",404));

        Subject subject = subjectRepository.findById(idSubject).get();

        if(subject == null)
        {
            throw new EntityNotFoundException("La asignatura no existe", 404);
        }
        if (subject.getStudents().contains(student))
        {
            throw new UnprocessableEntityException("el estudiante ya esta asignado a esa asignatura",422);
        }

        subject.getStudents().add(student);

        subjectRepository.save(subject);
    }

    @Override
    public void assignSubjects(String idStudent, List<SubjectInputDTO> subjects) throws Exception {
        Optional<Student> student = studentRepository.findById(idStudent);
        if (student.isPresent())
        {
            for (SubjectInputDTO subjectInputDTO : subjects)
            {
                Subject subject = subjectRepository.findById(subjectInputDTO.getIdSubject()).get();
                if (subject== null)
                {
                    throw new EntityNotFoundException("La asignatura no existe", 404);
                }
                subject.getStudents().add(student.get());
                subjectRepository.save(subject);
            }
        }
        else
        {
            throw new EntityNotFoundException("El estudiante no existe",404);
        }
    }

    @Override
    public void desAssingSubjects(String idStudent, List<SubjectInputDTO> subjects) throws Exception {
        Optional<Student> student = studentRepository.findById(idStudent);
        if (student.isPresent())
        {
            for (SubjectInputDTO subjectInputDTO : subjects)
            {
                Subject subject = subjectRepository.findById(subjectInputDTO.getIdSubject()).get();
                if (subject == null)
                {
                    throw new EntityNotFoundException("La asignatura no existe", 404);
                }
                subject.getStudents().remove(student.get());
                subjectRepository.save(subject);
            }
        }
        else
        {
            throw new EntityNotFoundException("El estudiante no existe",404);
        }
    }

}
