package com.project.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="room_no")
	private Integer roomNo; 
	
	@Column(name="room_type_code")
	private String roomTypeCode;
	
	@Column(name="floor")
	private Integer floor;
	
	@Column(name="front_face")
	private String frontFace;
	
	@Column(name="ac")
	private String ac;
	
	@Column(name="price")
	private float price;
	
	public Room() {
		
	}
	
	public Room(Integer roomNo, String roomTypeCode, Integer floor, String frontFace, String ac, float price) {
		super();
		this.roomNo = roomNo;
		this.roomTypeCode = roomTypeCode;
		this.floor = floor;
		this.frontFace = frontFace;
		this.ac = ac;
		this.price = price;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomTypeCode() {
		return roomTypeCode;
	}
	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	

}
