package com.example.ej7.crudvalidation.person.controller;

import com.example.ej7.crudvalidation.exceptions.EntityNotFoundException;

import com.example.ej7.crudvalidation.feign.FeingImp;
import com.example.ej7.crudvalidation.feign.IFeignServer;
import com.example.ej7.crudvalidation.person.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.person.model.PersonPage;
import com.example.ej7.crudvalidation.person.model.PersonSearchCriteria;
import com.example.ej7.crudvalidation.person.service.PersonServiceImp;
import com.example.ej7.crudvalidation.teacher.DTOs.TeacherOutputDTO;
import com.example.ej7.crudvalidation.teacher.model.Teacher;
import com.example.ej7.crudvalidation.teacher.service.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class readController {

    @Autowired
    PersonServiceImp personServiceImp;

    @Autowired
    TeacherServiceImp teacherServiceImp;

    @Autowired
    FeingImp feingImp;

    @Autowired
    IFeignServer iFeignServer;


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

    @GetMapping("/teacher1/{idTeacher}")
    public  TeacherOutputDTO getTeacherFeign(@PathVariable("idTeacher") String idTeacher) throws Exception {
        try {
            //return feingImp.getTeacher(idTeacher);
            return iFeignServer.getTeacher(idTeacher);
        }
        catch (EntityNotFoundException e)
        {
            throw  new EntityNotFoundException("el profesor no se ha encontrado",404);
        }
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundException> handleStorageException(EntityNotFoundException exception) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exception.getMessage());
        return responseEntity;
    }

    //#########################################################
    //#########################################################

    @GetMapping("/getCriteriaPerson")
    public Page<Person> getCriteriaPerson(PersonPage personPage,
                                          PersonSearchCriteria personSearchCriteria,
                                          @RequestParam(required = false) String username,
                                          @RequestParam(required = false) String name,
                                          @RequestParam(required = false) String surname,
                                          @RequestParam(required = false) String creationDate,
                                          @RequestParam(required = false) String dateCriteria,
                                          @RequestParam(required = false) String sortBy,
                                          @RequestParam Integer page) throws Exception {

        //transformar string en date
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(creationDate);

        personPage.setPageSize(page);
        personPage.setSortBy(sortBy);
        personSearchCriteria.setCriteriaDate(dateCriteria);
        personSearchCriteria.setCreatedDate(date);
        personSearchCriteria.setName(name);
        personSearchCriteria.setSurname(surname);
        personSearchCriteria.setUsername(username);
        return personServiceImp.getPersons(personPage,personSearchCriteria);
    }

}
