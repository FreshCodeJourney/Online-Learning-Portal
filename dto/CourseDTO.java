package com.olp.dto;

public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private String category;
    private Double price;
    private String level;
    private String thumbnailUrl;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public CourseDTO(Long id, String title, String description, String category, Double price, String level,
			String thumbnailUrl) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.level = level;
		this.thumbnailUrl = thumbnailUrl;
	}
	public CourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CourseDTO [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", level=" + level + ", thumbnailUrl=" + thumbnailUrl + "]";
	}

    
}
