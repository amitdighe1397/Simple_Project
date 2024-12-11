package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	private Long userId; // Primary key, unique identifier for each user
	private String username; // The username for the user
	private String email; // The email address of the user
	private String passwordHash; // Hashed password for the user
	private String role; // Role of the user (Admin, Customer, Staff)
	private LocalDateTime createdAt; // Timestamp of when the user was created
	private LocalDateTime updatedAt; // Timestamp of the last update to the user

	// Default constructor
	public User() {
	}

	// Constructor with fields
	public User(Long userId, String username, String email, String passwordHash, String role, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.passwordHash = passwordHash;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// Getters and setters

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	// Optional: Override toString() method for better readability
	@Override
	public String toString() {
		return "User{" + "userId=" + userId + ", username='" + username + '\'' + ", email='" + email + '\'' + ", role='"
				+ role + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
	}

}
