package com.olp.dto;

public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String role;
    private String bio;
    private String profilePictureUrl;
    private String contactNumber;

    public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}


	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}


	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}


	


	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", fullName=" + fullName + ", email=" + email + ", role=" + role + ", bio=" + bio
				+ ", profilePictureUrl=" + profilePictureUrl + ", contactNumber=" + contactNumber + "]";
	}


	public UserDTO(Long id, String fullName, String email, String role, String bio, String profilePictureUrl,
			String contactNumber) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.role = role;
		this.bio = bio;
		this.profilePictureUrl = profilePictureUrl;
		this.contactNumber = contactNumber;
		
	}


	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
}
