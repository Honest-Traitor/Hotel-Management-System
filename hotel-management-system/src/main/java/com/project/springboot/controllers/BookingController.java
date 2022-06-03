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
import com.project.springboot.models.Booking;
import com.project.springboot.repositories.BookingRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;

	//	get all booking API
	@GetMapping("/bookings/")	
	public List<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}

	//	create booking API
	@PostMapping("/booking-create")		
	public Booking createBooking(@RequestBody Booking booking) {
		return bookingRepository.save(booking);

	}

	//	get booking by Id API
	@GetMapping("/booking-get/{id}")	
	public ResponseEntity<Booking> getBookingById(@PathVariable String id){

		Long idLong = Long.parseUnsignedLong(id);
		Booking booking = bookingRepository.findById(idLong)
				.orElseThrow(()-> new ResourceNotFoundException("Booking doesn't exist with id [" + id + "]"));
		return ResponseEntity.ok(booking);
	}

	//	update booking by Id API
	@PutMapping("/booking-update/{id}")	
	public ResponseEntity<Booking> updatebookingById(@RequestBody Booking bookingDetails, @PathVariable Long id){

		Booking booking = bookingRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Booking doesn't exist with id [" + id + "]"));
		booking.setBookingId(bookingDetails.getBookingId());
		booking.setBookingDate(bookingDetails.getBookingDate());
		booking.setGuestName(bookingDetails.getGuestName());
		booking.setNoOfAdults(bookingDetails.getNoOfAdults());
		booking.setNoOfChildren(bookingDetails.getNoOfChildren());
		booking.setRoomTypeCode(bookingDetails.getRoomTypeCode());
		booking.setFrontFace(bookingDetails.getFrontFace());
		booking.setAc(bookingDetails.getAc());
		booking.setRoomNo(bookingDetails.getRoomNo());
		booking.setExtraBed(bookingDetails.getExtraBed());
		booking.setCheckIn(bookingDetails.getCheckIn());
		booking.setCheckOut(bookingDetails.getCheckOut());
		booking.setTotalAmount(bookingDetails.getTotalAmount());
		booking.setPaymentMode(bookingDetails.getPaymentMode());
		booking.setPaymentId(bookingDetails.getPaymentId());
		booking.setPaymentStatus(bookingDetails.getPaymentStatus());


		Booking updatedBooking = bookingRepository.save(booking);
		return ResponseEntity.ok(updatedBooking);
	}

	//  delete booking by Id
	@DeleteMapping("/booking-delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteBookingById(@PathVariable String id){

		Long idLong = Long.parseUnsignedLong(id);
		Booking booking = bookingRepository.findById(idLong)
				.orElseThrow(()-> new ResourceNotFoundException("Booking doesn't exist with id [" + id + "]"));
		bookingRepository.delete(booking);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
