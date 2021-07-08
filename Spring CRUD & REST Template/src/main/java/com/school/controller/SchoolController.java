package com.school.controller;

import com.school.model.School;
import com.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/myapp")
public class SchoolController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    SchoolService schoolService;

    @GetMapping("/schools")
    private List<School> getAllSchools(){
        return schoolService.getAllSchools();
    }

//    @GetMapping("/studentsTemplate")
//    public List<Object> getAllStudentsUsingTemplate(){
//        String url = "http://localhost:8080/students";
//        Object[] objects = restTemplate.getForObject(url, Object[].class);
//        return Arrays.asList(objects);
//    }

    @GetMapping("/schools/{school_id}")
    private School getSchool(@PathVariable("school_id") int hospital_id){
        return schoolService.getSchoolById(hospital_id);
    }

    @PostMapping("/insert")
    private int insertSchool(@RequestBody School school){
        schoolService.insertOrUpdateSchool(school);
        return school.getSchoolId();
    }

    @DeleteMapping("/delete")
    private int deleteSchool(@RequestBody School school){
        schoolService.removeSchool(school);
        return school.getSchoolId();
    }
}
