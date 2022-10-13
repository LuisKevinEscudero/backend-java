package com.example.ej13.mongodb.repository;


import com.example.ej13.mongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, Integer> {

}
