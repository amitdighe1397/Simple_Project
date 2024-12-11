package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RoomType {
    
	@Id
	private int roomTypeId;         // Primary Key
    private String name;            // e.g., Single, Double, Suite
    private String description;

    // Default constructor
    public RoomType() {}

    // Constructor with fields
    public RoomType(int roomTypeId, String name, String description) {
        this.roomTypeId = roomTypeId;
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

