package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTOs.UserRoomDTOs;
import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/users") // Base URL for all user-related operations
public class UserController {

	@Autowired
	private UserService userService;

	public static void main(String args[]) {
		

	}

	// Create a new user
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	// Update user profile
	@PutMapping("/{id}")
	public ResponseEntity<User> updateProfile(@PathVariable Long id, @RequestBody User user) {
		try {
			User updatedUser = userService.updateProfile(id, user);
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} catch (RuntimeException e) {
			// In case user not found, handle gracefully
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// Get a user by ID
	@GetMapping("/{id}")
	public ResponseEntity<UserRoomDTOs> getUserById(@PathVariable Long id) {
		try {
			UserRoomDTOs user = userService.getUserById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// Get all users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// Delete a user by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		try {
			String message = userService.deleteUser(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
	}
}
