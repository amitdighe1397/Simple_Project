package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

	List<Room> findByRoomStatus(String roomStatus);

	List<Room> findByRoomType(String roomType);

	Room findById(int roomId);

}
