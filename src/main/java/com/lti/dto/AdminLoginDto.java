package com.lti.dto;

public class AdminLoginDto {
	String adminEmail;
	String adminPassword;
	public AdminLoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminLoginDto(String adminEmail, String adminPassword) {
		super();
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
	
}
