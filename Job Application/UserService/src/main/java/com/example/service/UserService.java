package com.example.service;

import java.util.List;

import com.example.DTOs.UserRoomDTOs;
import com.example.model.User;

public interface UserService {

	// Register a new user
	User createUser(User user);

	User updateProfile(Long id, User user);

	// Get user by ID
	UserRoomDTOs getUserById(Long userId);

	List<User> getAllUsers();

	// Delete a user from the system
	String deleteUser(Long userId);

}
