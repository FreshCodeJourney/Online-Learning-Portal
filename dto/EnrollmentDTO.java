package com.olp.dto;

import java.time.LocalDateTime;

public class EnrollmentDTO {
    private Long id;
    private Long userId;
    private Long courseId;
    private LocalDateTime enrollmentDate;
    private String status;

    // Getters & Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
	@Override
	public String toString() {
		return "EnrollmentDTO [id=" + id + ", userId=" + userId + ", courseId=" + courseId + ", enrollmentDate="
				+ enrollmentDate + ", status=" + status + "]";
	}
	public EnrollmentDTO(Long id, Long userId, Long courseId, LocalDateTime enrollmentDate, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.courseId = courseId;
		this.enrollmentDate = enrollmentDate;
		this.status = status;
	}
	public EnrollmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
