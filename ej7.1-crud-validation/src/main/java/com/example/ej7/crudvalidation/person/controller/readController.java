package com.example.ej7.crudvalidation.person.controller;

import com.example.ej7.crudvalidation.exceptions.EntityNotFoundException;

import com.example.ej7.crudvalidation.feign.IFeignServer;
import com.example.ej7.crudvalidation.person.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.person.service.PersonServiceImp;
import com.example.ej7.crudvalidation.teacher.DTOs.TeacherOutputDTO;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import com.example.ej7.crudvalidation.teacher.service.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class readController {

    @Autowired
    PersonServiceImp personServiceImp;

    @Autowired
    TeacherServiceImp teacherServiceImp;

    @Autowired
    IFeignServer feignServer;



    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons()
    {
        return personServiceImp.findAll();
    }
    //creating a get mapping that retrieves the detail of a specific person

    @GetMapping("/getPerson/{idPerson}")
    public PersonOutputDTO getPersons(@PathVariable("idPerson") String idPerson) throws Exception {
        return personServiceImp.getPerson(idPerson);
    }

    @GetMapping("/getPersonByName/{name}")
    public List<PersonOutputDTO> getPersonsByName(@PathVariable("name") String name) throws Exception
    {
        return personServiceImp.findByName(name);
    }


    @GetMapping("/teacher/{idTeacher}")
    public  TeacherOutputDTO getTeacher(@PathVariable("idTeacher") String idTeacher) throws Exception {
        try {
            TeacherOutputDTO teacher = teacherServiceImp.getTeacher(idTeacher);
            return teacher;
        }
        catch (EntityNotFoundException e)
        {
            throw  new EntityNotFoundException("el profesor no se ha encontrado",404);
        }
    }

    /*@GetMapping("/teacher1/{idTeacher}")
    public  TeacherOutputDTO getTeacherFeign(@PathVariable("idTeacher") String idTeacher) throws Exception {
        try {
            return feignServer.getTeacher(idTeacher);
        }
        catch (EntityNotFoundException e)
        {
            throw  new EntityNotFoundException("el profesor no se ha encontrado",404);
        }
    }*/

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundException> handleStorageException(EntityNotFoundException exception) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exception.getMessage());
        return responseEntity;
    }


}
