package com.lti.dto;

public class ResponseModel {
	int[] answes;
	String[] credentials;
	public int[] getAnswes() {
		return answes;
	}
	public void setAnswes(int[] answes) {
		this.answes = answes;
	}
	public String[] getCredentials() {
		return credentials;
	}
	public void setCredentials(String[] credentials) {
		this.credentials = credentials;
	}
	public ResponseModel(int[] answes, String[] credentials) {
		super();
		this.answes = answes;
		this.credentials = credentials;
	}
	public ResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
