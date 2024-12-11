package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.RoomType;
import com.example.service.RoomManagementService;

@RestController
@RequestMapping("/api/roomtypes")
public class RoomTypeController {

	@Autowired
	private RoomManagementService roomTypeService;

	@PostMapping
	public ResponseEntity<RoomType> addRoomType(@RequestBody RoomType roomType) {
		RoomType createdRoomType = roomTypeService.addRoomType(roomType);
		return ResponseEntity.ok(createdRoomType);
	}

	@GetMapping("/{roomTypeId}")
	public ResponseEntity<RoomType> getRoomTypeById(@PathVariable int roomTypeId) {
		RoomType roomType = roomTypeService.getRoomTypeById(roomTypeId);
		return roomType != null ? ResponseEntity.ok(roomType) : ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<List<RoomType>> getAllRoomTypes() {
		List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
		return ResponseEntity.ok(roomTypes);
	}

	@PutMapping("/{roomTypeId}")
	public ResponseEntity<RoomType> updateRoomType(@PathVariable int roomTypeId, @RequestBody RoomType roomType) {
		RoomType updatedRoomType = roomTypeService.updateRoomType(roomTypeId, roomType);
		return updatedRoomType != null ? ResponseEntity.ok(updatedRoomType) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{roomTypeId}")
	public ResponseEntity<String> deleteRoomType(@PathVariable int roomTypeId) {
		String response = roomTypeService.deleteRoomType(roomTypeId);
		return response.equals("Success") ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
	}
}
