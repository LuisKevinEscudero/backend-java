package com.example.ej7.crudvalidation.repository;

import com.example.ej7.crudvalidation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String name);

}
