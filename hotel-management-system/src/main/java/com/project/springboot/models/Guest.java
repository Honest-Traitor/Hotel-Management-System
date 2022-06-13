package com.project.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="guests")
public class Guest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="date_of_birth")
	private String dob;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="permanent_address")
	private String permanentAddress;
	
	@Column(name="current_address")
	private String currentAddress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="id_type")
	private String idType;
	
	@Column(name="id_document")
	private String idDocument;
	
	public Guest() {
		
	}
	
	public Guest(String name, String dob, String state, String city, String permanentAddress, String currentAddress,
			String phoneNumber, String email, String idType, String idDocument) {
		super();
		
		this.name = name;
		this.dob = dob;
		this.state = state;
		this.city = city;
		this.permanentAddress = permanentAddress;
		this.currentAddress = currentAddress;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.idType = idType;
		this.idDocument = idDocument;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}
	

}
