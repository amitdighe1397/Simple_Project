package com.example.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.external.Room;

@FeignClient(name = "ROOM-SERVICE")
public interface AppConfig {

	@GetMapping("/api/rooms/{id}")
	public Room getRoomById(@PathVariable Long id);

}

class Demo {

	public void fun() {

	}
}
