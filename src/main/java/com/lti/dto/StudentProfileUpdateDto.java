package com.lti.dto;

public class StudentProfileUpdateDto {

	private String email;
	private String password;
	private String phoneNo;
	public StudentProfileUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentProfileUpdateDto(String email, String password, String phoneNo) {
		super();
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	

}
