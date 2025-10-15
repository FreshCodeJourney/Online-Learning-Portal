package com.olp.dto;

public class LessonDTO {
    private Long id;
    private String title;
    private String content;
    private String videoUrl;
    private int duration;
    private Long courseId;
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
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	@Override
	public String toString() {
		return "LessonDTO [id=" + id + ", title=" + title + ", content=" + content + ", videoUrl=" + videoUrl
				+ ", duration=" + duration + ", courseId=" + courseId + "]";
	}
	public LessonDTO(Long id, String title, String content, String videoUrl, int duration, Long courseId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.videoUrl = videoUrl;
		this.duration = duration;
		this.courseId = courseId;
	}
	public LessonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
}