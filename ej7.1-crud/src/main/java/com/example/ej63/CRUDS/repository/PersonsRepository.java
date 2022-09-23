package com.example.ej63.CRUDS.repository;

import com.example.ej63.CRUDS.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonsRepository extends JpaRepository<Persons, Integer> {

    List <Persons> findByName(String name);
}
