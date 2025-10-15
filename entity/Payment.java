package com.olp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.olp.enums.Status;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razorpayOrderId;
    private String razorpayPaymentId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    private int amount;
    private String currency;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Relation to User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("payments")  // prevents recursion
    private User user;

    // Relation to Course
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnore  // prevents recursion
    private Course course;

    // Getters and Setters
    // ... (keep previous)

    // Safe toString (do not include user/course)
    @Override
    public String toString() {
        return "Payment [id=" + id + ", razorpayOrderId=" + razorpayOrderId + ", razorpayPaymentId=" + razorpayPaymentId
                + ", status=" + status + ", amount=" + amount + ", currency=" + currency 
                + ", createdAt=" + createdAt + "]";
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}

	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}

	public String getRazorpayPaymentId() {
		return razorpayPaymentId;
	}

	public void setRazorpayPaymentId(String razorpayPaymentId) {
		this.razorpayPaymentId = razorpayPaymentId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
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

	// Constructors
    public Payment() {}
    public Payment(Long id, String razorpayOrderId, String razorpayPaymentId, Status status, int amount,
                   String currency, LocalDateTime createdAt, User user, Course course) {
        this.id = id;
        this.razorpayOrderId = razorpayOrderId;
        this.razorpayPaymentId = razorpayPaymentId;
        this.status = status;
        this.amount = amount;
        this.currency = currency;
        this.createdAt = createdAt;
        this.user = user;
        this.course = course;
    }
}
