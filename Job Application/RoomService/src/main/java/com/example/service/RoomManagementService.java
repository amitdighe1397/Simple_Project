package com.example.service;

import java.util.List;

import com.example.model.Room;
import com.example.model.RoomType;

public interface RoomManagementService {

	Room addRoom(Room room);

	Room updateRoom(int roomId, Room room);

	Room getRoomById(int roomId);

	List<Room> getAllRooms();

	String deleteRoom(int roomId);

	List<Room> getAvailableRooms();

	RoomType addRoomType(RoomType roomType);

	RoomType getRoomTypeById(int roomTypeId);

	List<RoomType> getAllRoomTypes();

	RoomType updateRoomType(int roomTypeId, RoomType roomType);

	String deleteRoomType(int roomTypeId);
}
