package com.project.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="booking_id")
	private String bookingId;

	@Column(name="booking_date")
	private String bookingDate;

	@Column(name="guest_name")
	private String guestName;

	@Column(name="no_of_adults")
	private Integer noOfAdults;

	@Column(name="no_of_children")
	private Integer noOfChildren;

	@Column(name="room_type_code")
	private String roomTypeCode;

	@Column(name="fornt_face")
	private String frontFace;

	@Column(name="ac")
	private String ac;

	@Column(name="room_no")
	private Integer roomNo;

	@Column(name="extra_bed")
	private String extraBed;

	@Column(name="check_in")
	private String checkIn;

	@Column(name="check_out")
	private String checkOut;

	@Column(name="total_amount")
	private String totalAmount;

	@Column(name="payment_mode")
	private String paymentMode;

	@Column(name="payment_id")
	private String paymentId;

	@Column(name="payment_status")
	private String paymentStatus;

	public Booking() {
		
	}
	public Booking(String bookingId, String bookingDate, String guestName, Integer noOfAdults, Integer noOfChildren,
			String roomTypeCode, String frontFace, String ac, Integer roomNo, String extraBed, String checkIn,
			String checkOut, String totalAmount, String paymentMode, String paymentId, String paymentStatus) {
		super();
		
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.guestName = guestName;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.roomTypeCode = roomTypeCode;
		this.frontFace = frontFace;
		this.ac = ac;
		this.roomNo = roomNo;
		this.extraBed = extraBed;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.totalAmount = totalAmount;
		this.paymentMode = paymentMode;
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public Integer getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(Integer noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public Integer getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(Integer noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public String getRoomTypeCode() {
		return roomTypeCode;
	}

	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}

	public String getFrontFace() {
		return frontFace;
	}

	public void setFrontFace(String frontFace) {
		this.frontFace = frontFace;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}

	public String getExtraBed() {
		return extraBed;
	}

	public void setExtraBed(String extraBed) {
		this.extraBed = extraBed;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


}
