package com.olp.service.impl;

import com.olp.dto.EnrollmentDTO;
import com.olp.entity.Course;
import com.olp.entity.Enrollment;
import com.olp.entity.User;
import com.olp.exception.ResourceNotFoundException;
import com.olp.repository.CourseRepository;
import com.olp.repository.EnrollmentRepository;
import com.olp.repository.UserRepository;
import com.olp.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public EnrollmentDTO enrollUser(Long userId, Long courseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + courseId));

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDateTime.now());
        enrollment.setStatus("ACTIVE");

        Enrollment saved = enrollmentRepository.save(enrollment);
        return mapToDTO(saved);
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentRepository.findAll()
                .stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EnrollmentDTO getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with ID: " + id));
    }

    @Override
    public void deleteEnrollment(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Enrollment not found with ID: " + id);
        }
        enrollmentRepository.deleteById(id);
    }

    // Helper method
    private EnrollmentDTO mapToDTO(Enrollment enrollment) {
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(enrollment.getId());
        dto.setUserId(enrollment.getUser().getId());
        dto.setCourseId(enrollment.getCourse().getId());
        dto.setEnrollmentDate(enrollment.getEnrollmentDate());
        dto.setStatus(enrollment.getStatus());
        return dto;
    }
    @Override
    public EnrollmentDTO updateEnrollmentStatus(Long enrollmentId, String status) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with ID: " + enrollmentId));

        enrollment.setStatus(status);   // e.g. ACTIVE, COMPLETED, CANCELLED
        Enrollment updated = enrollmentRepository.save(enrollment);

        return mapToDTO(updated);
    }

}
