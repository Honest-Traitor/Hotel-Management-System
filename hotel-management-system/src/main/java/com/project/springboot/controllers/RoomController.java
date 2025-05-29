package com.project.springboot.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.springboot.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.exceptions.ResourceNotFoundException;
import com.project.springboot.models.Room;
import com.project.springboot.repositories.RoomRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class RoomController {
	
	@Autowired
	private RoomService roomService;

	//	get all Rooms API
	@GetMapping("/rooms/")	
	public List<Room> getAllRooms(){
		return roomService.getAllRooms();
	}

	//	create Room API
	@PostMapping("/room-create")		
	public Room createRoom(@RequestBody Room room) {
		return roomService.createRoom(room);
	}

	//	get Room by Id API
	@GetMapping("/room-get/{id}")	
	public ResponseEntity<Room> getRoomById(@PathVariable String id){

		Room room = roomService.getRoomById(id);
		return ResponseEntity.ok(room);
	}

	//	update Room by Id API
	@PutMapping("/room-update/{id}")	
	public ResponseEntity<Room> updateRoomById(@RequestBody Room roomDetails, @PathVariable String id){
		Room updatedRoom = roomService.updateRoomById(roomDetails,id);
		return ResponseEntity.ok(updatedRoom);
	}
	
	//  delete Room by Id
	@DeleteMapping("/room-delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteRoomById(@PathVariable String id){
		
		Map response = roomService.deleteRoomeById(id);
		return ResponseEntity.ok(response);
	}

}
