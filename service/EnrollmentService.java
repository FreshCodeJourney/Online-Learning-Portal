package com.olp.service;

import com.olp.dto.EnrollmentDTO;
import java.util.List;

public interface EnrollmentService {

    EnrollmentDTO enrollUser(Long userId, Long courseId);

    List<EnrollmentDTO> getAllEnrollments();

    EnrollmentDTO getEnrollmentById(Long id);

    void deleteEnrollment(Long id);

    EnrollmentDTO updateEnrollmentStatus(Long enrollmentId, String status);
}
