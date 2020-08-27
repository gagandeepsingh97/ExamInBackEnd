package com.lti.dto;

public class StudentDto {

	private String name;
	private String city;
	private String state;
	private String email;
	private String phoneNo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public StudentDto(String name, String city, String state, String email, String phoneNo) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}