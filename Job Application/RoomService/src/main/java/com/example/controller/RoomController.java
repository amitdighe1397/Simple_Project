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

import com.example.model.Room;
import com.example.service.RoomManagementService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

	@Autowired
	private RoomManagementService roomService;

	@PostMapping
	public ResponseEntity<Room> addRoom(@RequestBody Room room) {
		Room createdRoom = roomService.addRoom(room);
		return ResponseEntity.ok(createdRoom);
	}

	@PutMapping("/{roomId}")
	public ResponseEntity<Room> updateRoom(@PathVariable int roomId, @RequestBody Room room) {
		Room updatedRoom = roomService.updateRoom(roomId, room);
		return updatedRoom != null ? ResponseEntity.ok(updatedRoom) : ResponseEntity.notFound().build();
	}

	@GetMapping("/{roomId}")
	public ResponseEntity<Room> getRoomById(@PathVariable int roomId) {
		Room room = roomService.getRoomById(roomId);
		return room != null ? ResponseEntity.ok(room) : ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<List<Room>> getAllRooms() {
		List<Room> rooms = roomService.getAllRooms();
		return ResponseEntity.ok(rooms);
	}

	@DeleteMapping("/{roomId}")
	public ResponseEntity<String> deleteRoom(@PathVariable int roomId) {
		 roomService.deleteRoom(roomId);
		return new ResponseEntity<>("data deleted",HttpStatus.OK);
	}

	@GetMapping("/available")
	public ResponseEntity<List<Room>> getAvailableRooms() {
		List<Room> availableRooms = roomService.getAvailableRooms();
		return ResponseEntity.ok(availableRooms);
	}
}
