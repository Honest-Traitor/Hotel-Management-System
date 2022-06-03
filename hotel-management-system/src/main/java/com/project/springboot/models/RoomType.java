package com.project.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room_types")
public class RoomType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="no_of_beds")
	private Integer noOfBeds;
	
	@Column(name="price")
	private float price;
	
	public RoomType() {
		
	}
	
	public RoomType(String code, Integer noOfBeds, float price) {
		super();

		this.code = code;
		this.noOfBeds = noOfBeds;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getNoOfBeds() {
		return noOfBeds;
	}

	public void setNoOfBeds(Integer noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
