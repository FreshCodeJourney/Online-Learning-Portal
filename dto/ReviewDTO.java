package com.olp.dto;


public class ReviewDTO {
    private Long id;
    private int rating;
    private String comment;
    private Long userId;
    private Long courseId;
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
	@Override
	public String toString() {
		return "ReviewDTO [id=" + id + ", rating=" + rating + ", comment=" + comment + ", userId=" + userId
				+ ", courseId=" + courseId + "]";
	}
	public ReviewDTO(Long id, int rating, String comment, Long userId, Long courseId) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.userId = userId;
		this.courseId = courseId;
	}
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
