package com.school.repository;

import com.school.model.School;
import com.school.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
