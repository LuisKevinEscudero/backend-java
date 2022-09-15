package com.example.ej7.crudvalidation.teacher.repository;

import com.example.ej7.crudvalidation.teacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}

