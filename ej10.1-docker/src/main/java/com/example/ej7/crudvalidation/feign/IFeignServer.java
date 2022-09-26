package com.example.ej7.crudvalidation.feign;

import com.example.ej7.crudvalidation.teacher.DTOs.TeacherOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "feignTest", url = "http://localhost:8081")
public interface IFeignServer {
    @GetMapping("/teacherFeign/{idTeacher}")
    TeacherOutputDTO getTeacher(String idTeacher);
}