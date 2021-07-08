package com.school.repository;

import com.school.model.School;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Integer> {
}
