package com.lti.dto;

public class GetQuestionDto {
	
	int subjectId;
	int prevQuestionNumber;
	
	public GetQuestionDto(int subjectId, int prevQuestionNumber) {
		super();
		this.subjectId = subjectId;
		this.prevQuestionNumber = prevQuestionNumber;
	}
	public GetQuestionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getPrevQuestionNumber() {
		return prevQuestionNumber;
	}
	public void setPrevQuestionNumber(int prevQuestionNumber) {
		this.prevQuestionNumber = prevQuestionNumber;
	}
	
	

}
