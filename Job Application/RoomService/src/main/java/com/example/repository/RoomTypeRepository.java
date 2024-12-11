package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

	RoomType findById(int roomTypeId);

}
