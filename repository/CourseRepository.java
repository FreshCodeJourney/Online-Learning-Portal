package com.olp.repository;

import com.olp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Later you can add custom queries like findByCategory, findByLevel etc.
}
