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
import com.project.springboot.models.Guest;
import com.project.springboot.repositories.GuestRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class GuestController {

	@Autowired
	private GuestRepository guestRepository;

	//	get all guests API
	@GetMapping("/guests/")	
	public List<Guest> getAllGuests(){
		return guestRepository.findAll();
	}

	//	create guest API
	@PostMapping("/guest-create")		
	public Guest createGuest(@RequestBody Guest guest) {
		return guestRepository.save(guest);

	}

	//	get guest by Id API
	@GetMapping("/guest-get/{id}")	
	public ResponseEntity<Guest> getGuestById(@PathVariable String id){

		Long idLong = Long.parseUnsignedLong(id);
		Guest guest = guestRepository.findById(idLong)
				.orElseThrow(()-> new ResourceNotFoundException("Guest doesn't exist with id [" + id + "]"));
		return ResponseEntity.ok(guest);
	}

	//	update guest by Id API
	@PutMapping("/guest-update/{id}")	
	public ResponseEntity<Guest> updateGuestById(@RequestBody Guest guestDetails, @PathVariable Long id){

		Guest guest = guestRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Guest doesn't exist with id [" + id + "]"));
		guest.setName(guestDetails.getName());
		guest.setDob(guestDetails.getDob());
		guest.setState(guestDetails.getState());
		guest.setCity(guestDetails.getCity());
		guest.setPermanentAddress(guestDetails.getPermanentAddress());
		guest.setCurrentAddress(guestDetails.getCurrentAddress());
		guest.setPhoneNumber(guestDetails.getPhoneNumber());
		guest.setEmail(guestDetails.getEmail());
		guest.setIdType(guestDetails.getIdType());
		guest.setIdDocument(guestDetails.getIdDocument());

		Guest updatedGuest = guestRepository.save(guest);
		return ResponseEntity.ok(updatedGuest);
	}

	//  delete guest by Id
	@DeleteMapping("/guest-delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteGuestById(@PathVariable String id){

		Long idLong = Long.parseUnsignedLong(id);
		Guest guest = guestRepository.findById(idLong)
				.orElseThrow(()-> new ResourceNotFoundException("Guest doesn't exist with id [" + id + "]"));
		guestRepository.delete(guest);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
