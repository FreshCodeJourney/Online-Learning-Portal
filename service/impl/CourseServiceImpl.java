package com.olp.service.impl;

import com.olp.dto.CourseDTO;
import com.olp.entity.Course;
import com.olp.exception.ResourceNotFoundException;
import com.olp.repository.CourseRepository;
import com.olp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));
        return mapToDTO(course);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = mapToEntity(courseDTO);
        Course saved = courseRepository.save(course);
        return mapToDTO(saved);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));

        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        course.setCategory(courseDTO.getCategory());
        course.setPrice(courseDTO.getPrice());
        course.setLevel(courseDTO.getLevel());
        course.setThumbnailUrl(courseDTO.getThumbnailUrl());

        Course updated = courseRepository.save(course);
        return mapToDTO(updated);
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course not found with ID: " + id);
        }
        courseRepository.deleteById(id);
    }

    // 🔹 Mapping methods
    private CourseDTO mapToDTO(Course entity) {
        return new CourseDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getCategory(),
                entity.getPrice(),
                entity.getLevel(),
                entity.getThumbnailUrl()
        );
    }

    private Course mapToEntity(CourseDTO dto) {
        Course course = new Course();
        course.setId(dto.getId());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setCategory(dto.getCategory());
        course.setPrice(dto.getPrice());
        course.setLevel(dto.getLevel());
        course.setThumbnailUrl(dto.getThumbnailUrl());
        return course;
    }
}
