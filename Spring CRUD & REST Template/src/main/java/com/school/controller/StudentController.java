package com.school.controller;

import com.school.model.School;
import com.school.model.Student;
import com.school.repository.StudentRepository;
import com.school.service.SchoolService;
import com.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/getAll")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    private List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{student_id}")
    private Student getStudent(@PathVariable("student_id") int student_id){
        return studentService.getStudentById(student_id);
    }

    @PostMapping("/studentInsert")
    private int insertStudent(@RequestBody Student student){
        studentService.insertOrUpdateStudent(student);
        return student.getStudentId();
    }

    @DeleteMapping("/studentDelete")
    private int deleteStudent(@RequestBody Student student){
        studentService.removeStudent(student);
        return student.getStudentId();
    }
}
