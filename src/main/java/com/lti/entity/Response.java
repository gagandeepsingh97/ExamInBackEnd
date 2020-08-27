package com.lti.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name="RESPONSE")
public class Response {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="RESID")
    private int responseId;
    
    
    @Column(name="SELECTED_OPTION",length=1)
    private int selectedOption;
    
    @ManyToOne
    @JoinColumn(name="SID")
    private Student student;
    
    @OneToOne
    @JoinColumn(name="QUESID")
    private Question question;
    
    @ManyToOne
    @JoinColumn(name="RID")
    private Report report;
    
    public Report getReport() {
        return report;
    }

 

    public void setReport(Report report) {
        this.report = report;
    }

 

 

 

  
    public int getResponseId() {
        return responseId;
    }

 

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

 

    public int getSelectedOption() {
        return selectedOption;
    }

 

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }

 

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    
 

 

    public Response(int responseId, int selectedOption, Student student, Question question, Report report) {
        super();
        this.responseId = responseId;
        this.selectedOption = selectedOption;
        this.student = student;
        this.question = question;
        this.report = report;
    }

 

    public Response() {
        super();
        // TODO Auto-generated constructor stub
    }

 

 

 

    
    
    
}
 