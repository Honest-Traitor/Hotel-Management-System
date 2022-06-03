package com.project.springboot.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private RoomRepository roomRepository;

	//	get all Rooms API
	@GetMapping("/rooms/")	
	public List<Room> getAllRooms(){
		return roomRepository.findAll();
	}

	//	create Room API
	@PostMapping("/room-create")		
	public Room createRoom(@RequestBody Room room) {
		return roomRepository.save(room);

	}

	//	get Room by Id API
	@GetMapping("/room-get/{id}")	
	public ResponseEntity<Room> getRoomById(@PathVariable String id){

		Long idLong = Long.parseUnsignedLong(id);
		Room room = roomRepository.findById(idLong)
				.orElseThrow(()-> new ResourceNotFoundException("Room doesn't exist with id [" + id + "]"));
		return ResponseEntity.ok(room);
	}

	//	update Room by Id API
	@PutMapping("/room-update/{id}")	
	public ResponseEntity<Room> updateRoomById(@RequestBody Room roomDetails, @PathVariable Long id){

		Room room = roomRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Room doesn't exist with id [" + id + "]"));
		room.setRoomNo(roomDetails.getRoomNo());
		room.setRoomTypeCode(roomDetails.getRoomTypeCode());
		room.setFloor(roomDetails.getFloor());
		room.setFrontFace(roomDetails.getFrontFace());
		room.setAc(roomDetails.getAc());
		room.setPrice(roomDetails.getPrice());
		
		Room updatedRoom = roomRepository.save(room);
		return ResponseEntity.ok(updatedRoom);
	}
	
	//  delete Room by Id
	@DeleteMapping("/room-delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteRoomById(@PathVariable String id){
		
		Long idLong = Long.parseUnsignedLong(id);
		Room room = roomRepository.findById(idLong)
				.orElseThrow(()-> new ResourceNotFoundException("Room doesn't exist with id [" + id + "]"));
		roomRepository.delete(room);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
