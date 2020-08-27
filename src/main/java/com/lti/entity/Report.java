package com.lti.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="REPORT")
public class Report {

    @Id
    @GeneratedValue
    @Column(name="RID",length=20)
    private int reportId;
    @Column(name="ATTEMPTNO",length=20)
    private int nAttempt;
  //private String nAttempt;
    @Column(name="MARKS",length=20)
    private int marks;
    //private String marks;
    @Column(name="STATUS",length=1)
    private boolean passingStatus;
    
    @ManyToOne
    @JoinColumn(name="SID")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name="SUBID")
    private Subject subject;
    
    @OneToMany(mappedBy = "report")
    private List<Response> response;

 

    public int getReportId() {
        return reportId;
    }

 

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

 

    public int getnAttempt() {
        return nAttempt;
    }

 

    public void setnAttempt(int nAttempt) {
        this.nAttempt = nAttempt;
    }

 

    public int getMarks() {
        return marks;
    }

 

    public void setMarks(int marks) {
        this.marks = marks;
    }

 

    public boolean isPassingStatus() {
        return passingStatus;
    }

 

    public void setPassingStatus(boolean passingStatus) {
        this.passingStatus = passingStatus;
    }

 

    public Student getStudent() {
        return student;
    }

 

    public void setStudent(Student student) {
        this.student = student;
    }

 

    public Subject getSubject() {
        return subject;
    }

 

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

 

    public List<Response> getResponse() {
        return response;
    }

 

    public void setResponse(List<Response> response) {
        this.response = response;
    }

 

    public Report(int reportId, int nAttempt, int marks, boolean passingStatus, Student student, Subject subject,
            List<Response> response) {
        super();
        this.reportId = reportId;
        this.nAttempt = nAttempt;
        this.marks = marks;
        this.passingStatus = passingStatus;
        this.student = student;
        this.subject = subject;
        this.response = response;
    }

 

    public Report() {
        super();
        // TODO Auto-generated constructor stub
    }
    
}