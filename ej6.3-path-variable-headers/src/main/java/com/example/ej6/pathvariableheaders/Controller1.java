package com.example.ej6.pathvariableheaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller1 {

    @Autowired
    Person person;

    @PostMapping("/JSONperson")
    public Person addPerson(@RequestBody Person person) {
        System.out.println("Person added: " + person.getName() + " " + person.getLastName() + " " + person.getAge());
        return person;
    }

    @GetMapping("/Getperson")
    public Person getPerson() {
        System.out.println("Person retrieved: " + person.getName() + " " + person.getLastName() + " " + person.getAge());
        return person;
    }

    @PutMapping("/Putperson")
    public Person putPerson(@RequestParam String name, @RequestParam String lastName, @RequestParam int age) {
        person.setName(name);
        person.setLastName(lastName);
        person.setAge(age);
        System.out.println("Person updated: " + person.getName() + " " + person.getLastName() + " " + person.getAge());
        return person;
    }

}
