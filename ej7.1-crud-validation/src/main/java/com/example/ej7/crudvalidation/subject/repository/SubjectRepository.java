package com.example.ej7.crudvalidation.subject.repository;

import com.example.ej7.crudvalidation.subject.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {

}
