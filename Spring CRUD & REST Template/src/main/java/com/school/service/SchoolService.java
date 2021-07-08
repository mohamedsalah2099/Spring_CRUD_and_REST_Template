package com.school.service;

import com.school.model.School;
import com.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTaskHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    public List<School> getAllSchools(){
        List<School> schools = new ArrayList<>();
        schoolRepository.findAll().forEach(schools::add);
        return schools;
    }

    public void insertOrUpdateSchool(School school){
        schoolRepository.save(school);
    }

    public void removeSchool(School school){
        schoolRepository.delete(school);
    }

    public School getSchoolById(int id){
        return schoolRepository.findById(id).get();
    }
}
