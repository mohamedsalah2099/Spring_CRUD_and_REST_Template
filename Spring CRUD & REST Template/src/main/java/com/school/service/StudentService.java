package com.school.service;

import com.school.model.School;
import com.school.model.Student;
import com.school.repository.SchoolRepository;
import com.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public void insertOrUpdateStudent(Student student){
        studentRepository.save(student);
    }

    public void removeStudent(Student student){
        studentRepository.delete(student);
    }

    public Student getStudentById(int id){
        return studentRepository.findById(id).get();
    }
}
