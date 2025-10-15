package com.olp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int rating; // 1 to 5

    @Column(nullable = false, length = 1000)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;   // reviewer

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course; // course being reviewed

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", comment=" + comment + ", user=" + user + ", course="
				+ course + "]";
	}

	public Review(Long id, int rating, String comment, User user, Course course) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.user = user;
		this.course = course;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
