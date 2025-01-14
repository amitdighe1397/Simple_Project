package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTOs.UserRoomDTOs;
import com.example.configuration.AppConfig;
import com.example.model.User;
import com.example.model.external.Room;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AppConfig appConfig;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateProfile(Long id, User user) {

		User existingUser = userRepository.findById(id).get();
		existingUser.setUsername(user.getUsername());
		existingUser.setCreatedAt(user.getCreatedAt());
		existingUser.setEmail(user.getEmail());
		existingUser.setPasswordHash(user.getPasswordHash());
		existingUser.setRole(user.getRole());
		existingUser.setUpdatedAt(user.getUpdatedAt());
		return userRepository.save(existingUser);
	}

	@Override
	public UserRoomDTOs getUserById(Long userId) {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id " + userId));
		Room room = appConfig.getRoomById(user.getUserId());

		return mapUserRoomDTOs(user, room) ;
	}

	public  UserRoomDTOs mapUserRoomDTOs(User user, Room room) {
		UserRoomDTOs uDtOs = new UserRoomDTOs();
		uDtOs.setUser(user);
		uDtOs.setRoom(room);
		return uDtOs;

	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public String deleteUser(Long userId) {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id " + userId));
		userRepository.delete(user);
		return "User Deleted...!";
	}
}
