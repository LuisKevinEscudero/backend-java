package com.example.ej7.crudvalidation.profesor.repository;

import com.example.ej7.crudvalidation.profesor.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}

