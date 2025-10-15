package com.olp.controller;

import com.olp.dto.EnrollmentDTO;
import com.olp.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/olp/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/add/{userId}/{courseId}")
    public EnrollmentDTO enrollUser(@PathVariable Long userId, @PathVariable Long courseId) {
        return enrollmentService.enrollUser(userId, courseId);
    }

    @GetMapping("/allenrollments")
    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public EnrollmentDTO getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return "Enrollment deleted successfully.";
    }

    // New Update Endpoint
    @PutMapping("/{id}/status")
    public EnrollmentDTO updateEnrollmentStatus(@PathVariable Long id,@RequestParam String status) {
        return enrollmentService.updateEnrollmentStatus(id, status);
    }
}
