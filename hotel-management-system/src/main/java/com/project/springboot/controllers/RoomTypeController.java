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
import com.project.springboot.models.RoomType;
import com.project.springboot.repositories.RoomTypeRepository;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class RoomTypeController {
	
	@Autowired
	private RoomTypeRepository roomTypeRepository;

	//	get all RoomTypes API
	@GetMapping("/roomtypes/")	
	public List<RoomType> getAllRoomTypes(){
		return roomTypeRepository.findAll();
	}

	//	create Room Type API
	@PostMapping("/roomtype-create")		
	public RoomType createRoomType(@RequestBody RoomType roomType) {
		return roomTypeRepository.save(roomType);

	}

	//	get Room Type by Id API
	@GetMapping("/roomtype-get/{id}")	
	public ResponseEntity<RoomType> getRoomTypeById(@PathVariable String id){

		Long idLong = Long.parseUnsignedLong(id);
		RoomType roomType = roomTypeRepository.findById(idLong)
				.orElseThrow(()-> new ResourceNotFoundException("Room Type doesn't exist with id [" + id + "]"));
		return ResponseEntity.ok(roomType);
	}

	//	update Room Type by Id API
	@PutMapping("/roomtype-update/{id}")	
	public ResponseEntity<RoomType> updateRoomTypeById(@RequestBody RoomType roomTypeDetails, @PathVariable Long id){

		RoomType roomType = roomTypeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Room Type doesn't exist with id [" + id + "]"));
		roomType.setCode(roomTypeDetails.getCode());
		roomType.setNoOfBeds(roomTypeDetails.getNoOfBeds());
		roomType.setPrice(roomTypeDetails.getPrice());
		
		RoomType updatedRoomType = roomTypeRepository.save(roomType);
		return ResponseEntity.ok(updatedRoomType);
	}
	
	//  delete Room Type by Id
	@DeleteMapping("/roomtype-delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteRoomTypeById(@PathVariable String id){
		
		Long idLong = Long.parseUnsignedLong(id);
		RoomType roomType = roomTypeRepository.findById(idLong)
				.orElseThrow(()-> new ResourceNotFoundException("RoomType doesn't exist with id [" + id + "]"));
		roomTypeRepository.delete(roomType);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
