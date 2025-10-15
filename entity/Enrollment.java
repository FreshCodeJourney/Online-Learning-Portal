package com.olp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each enrollment links a User with a Course
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private LocalDateTime enrollmentDate;

    private String status;  // e.g., ACTIVE, COMPLETED, CANCELLED

    // Getters & Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
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
		return "Enrollment [id=" + id + ", user=" + user + ", course=" + course + ", enrollmentDate=" + enrollmentDate
				+ ", status=" + status + "]";
	}
	public Enrollment(Long id, User user, Course course, LocalDateTime enrollmentDate, String status) {
		super();
		this.id = id;
		this.user = user;
		this.course = course;
		this.enrollmentDate = enrollmentDate;
		this.status = status;
	}
	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
