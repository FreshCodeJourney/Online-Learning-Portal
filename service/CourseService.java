package com.olp.service;

import com.olp.dto.CourseDTO;
import java.util.List;

public interface CourseService {
    CourseDTO getCourseById(Long id);
    List<CourseDTO> getAllCourses();
    CourseDTO createCourse(CourseDTO courseDTO);
    CourseDTO updateCourse(Long id, CourseDTO courseDTO);
    void deleteCourse(Long id);
}
