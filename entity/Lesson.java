package com.olp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String content; // Lesson text/video link

    private String videoUrl; // optional field

    private int duration; // in minutes

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", title=" + title + ", content=" + content + ", videoUrl=" + videoUrl
				+ ", duration=" + duration + ", course=" + course + "]";
	}

	public Lesson(Long id, String title, String content, String videoUrl, int duration, Course course) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.videoUrl = videoUrl;
		this.duration = duration;
		this.course = course;
	}

	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
