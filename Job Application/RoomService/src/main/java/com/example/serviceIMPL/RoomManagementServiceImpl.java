package com.example.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Room;
import com.example.model.RoomType;
import com.example.repository.RoomRepository;
import com.example.repository.RoomTypeRepository;
import com.example.service.RoomManagementService;

@Service
public class RoomManagementServiceImpl implements RoomManagementService {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private RoomTypeRepository roomTypeRepository;

	@Override
	public Room addRoom(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public Room updateRoom(int roomId, Room room) {
		Room room2 = roomRepository.findById(roomId);
		room2.setCreatedAt(room.getCreatedAt());
		room2.setDescription(room.getDescription());
		room2.setPricePerNight(room.getPricePerNight());
		room2.setRoomId(room.getRoomId());
		room2.setRoomNumber(room.getRoomNumber());
		room2.setRoomStatus(room.getRoomStatus());
		room2.setRoomType(room.getRoomType());
		room2.setUpdatedAt(room.getUpdatedAt());
		return roomRepository.save(room2);
	}

	@Override
	public Room getRoomById(int roomId) {

		return roomRepository.findById(roomId);

	}

	@Override
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	@Override
	public String deleteRoom(int roomId) {
		Room room = roomRepository.findById(roomId);
		roomRepository.delete(room);
		return "data is deleted..!";
	}

	@Override
	public List<Room> getAvailableRooms() {
		return roomRepository.findAll();
	}

	@Override
	public RoomType addRoomType(RoomType roomType) {

		return roomTypeRepository.save(roomType);
	}

	@Override
	public RoomType getRoomTypeById(int roomTypeId) {

		return roomTypeRepository.findById(roomTypeId);
	}

	@Override
	public List<RoomType> getAllRoomTypes() {

		return roomTypeRepository.findAll();
	}

	@Override
	public RoomType updateRoomType(int roomTypeId, RoomType roomType) {
		RoomType roomType2 = roomTypeRepository.findById(roomTypeId);
		roomType2.setName(roomType.getName());
		roomType2.setDescription(roomType.getDescription());
		return roomTypeRepository.save(roomType2);
	}

	@Override
	public String deleteRoomType(int roomTypeId) {
		roomTypeRepository.deleteById(roomTypeId);
		return "data is deleted..";
	}

}
