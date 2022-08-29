package com.example.ej63.CRUDS.repository;

import com.example.ej63.CRUDS.model.Persons;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository<Persons, Integer> {

}
