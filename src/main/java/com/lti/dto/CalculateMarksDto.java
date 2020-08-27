package com.lti.dto;

public class CalculateMarksDto {

	private int studentId; 
	private int subjectId;
	
	public CalculateMarksDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CalculateMarksDto(int studentId, int subjectId) {
		super();
		this.studentId = studentId;
		this.subjectId = subjectId;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

}