package com.lti.entity;

import java.util.Set;
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
    private String nAttempt;
    @Column(name="MARKS",length=20)
    private String marks;
    @Column(name="STATUS",length=20)
    private boolean passingStatus;
    
    @ManyToOne
    @JoinColumn(name="SID")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name="SUBID")
    private Subject subject;
    
    @OneToMany(mappedBy = "report")
    private Set<Response>response;

 

    public int getReportId() {
        return reportId;
    }

 

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

 

    public String getnAttempt() {
        return nAttempt;
    }

 

    public void setnAttempt(String nAttempt) {
        this.nAttempt = nAttempt;
    }

 

    public String getMarks() {
        return marks;
    }

 

    public void setMarks(String marks) {
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

 

    public Set<Response> getResponse() {
        return response;
    }

 

    public void setResponse(Set<Response> response) {
        this.response = response;
    }

 

    public Report(int reportId, String nAttempt, String marks, boolean passingStatus, Student student, Subject subject,
            Set<Response> response) {
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