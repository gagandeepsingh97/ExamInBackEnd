package com.lti.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.lti.entity.Response;
import com.lti.entity.Subject;

public class ReturnQuestionPaper {

    private int questionId; // sir said we cant keep string :(
    
    private int subjectId;  // data type not confirm :(
    private String questionDescription;  // what is java?
 
    private int questionNumber;
    
    private String option1;  // an object
    private String option2;  // an animal
    private String option3;  // a place
    private String option4;  // a language
    private String correctOption;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	public ReturnQuestionPaper(int questionId, int subjectId, String questionDescription, int questionNumber,
			String option1, String option2, String option3, String option4, String correctOption) {
		super();
		this.questionId = questionId;
		this.subjectId = subjectId;
		this.questionDescription = questionDescription;
		this.questionNumber = questionNumber;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctOption = correctOption;
	}

    
    
    
    
    
    

}
