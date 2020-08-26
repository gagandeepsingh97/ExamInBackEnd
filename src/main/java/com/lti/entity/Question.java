package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

 


@Entity
@Table(name="QUESTION")
public class Question {
    @Id
    @GeneratedValue()
    @Column(name="QUESID", length = 10)
    private int questionId; // sir said we cant keep string :(
    
//    @Transient
//    @Column(name="SUBID", length = 10)
//    private int subjectId;  // data type not confirm :(
	@Column(name="QUESDESC") // length????
    private String questionDescription;  // what is java?
    
    @Column(name="QUESTIONNUMBER", length = 10)
    private int questionNumber;
    
    @Column(name="OPTION1", length = 50)
    private String option1;  // an object
    @Column(name="OPTION2", length = 50)
    private String option2;  // an animal
    @Column(name="OPTION3", length = 50)  
    private String option3;  // a place
    @Column(name="OPTION4", length = 50)
    private String option4;  // a language
    
    @Column(name="CORRECT_OPTION",length=10)
    private String correctOption;
    
    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name="SUBJECTID")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Subject subject;
    
    @OneToOne(mappedBy="question")
    private Response response;
    
    @Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionDescription=" + questionDescription
				+ ", questionNumber=" + questionNumber + ", option1=" + option1 + ", option2=" + option2 + ", option3="
				+ option3 + ", option4=" + option4 + ", correctOption=" + correctOption + ", subject=" + subject
				+ ", response=" + response + "]";
	}

	public Question(int questionId, //int subjectId,
			String questionDescription, int questionNumber, String option1,
			String option2, String option3, String option4, String correctOption, Subject subject, Response response) {
		super();
		this.questionId = questionId;
//		this.subjectId = subjectId;
		this.questionDescription = questionDescription;
		this.questionNumber = questionNumber;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctOption = correctOption;
		this.subject = subject;
		this.response = response;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

//	public int getSubjectId() {
//		return subjectId;
//	}
//
//	public void setSubjectId(int subjectId) {
//		this.subjectId = subjectId;
//	}

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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

 
 

    

 


}