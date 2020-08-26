package com.lti.entity;

 


import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

 

import com.fasterxml.jackson.annotation.JsonFormat;

 

import javax.persistence.OneToMany;

 

@Entity
@Table(name="STUDENT")
public class Student {

 

    @Id
    @GeneratedValue
    @Column(name="SID", length = 10)
    private int studentId;
    @Column(name="SNAME", length=20)
    private String name;
    @Column(name="SEMAIL", length=30)
    private String email;
    @Column(name="SPASS", length=20)
    private String password;
    @Column(name="SPHONE", length=10)
    private String phoneNo;
    @Column(name="SDOB", length=10)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate  dob;
    @Column(name="SCITY", length=20)
    private String city;
    @Column(name="SSTATE", length=20)
    private String state;
    @Column(name="SQUALIFICATION", length = 20)
    private String qualification;
    @Column(name="SCOMPLETIONYEAR", length = 4)
    private String yearCompletion;
    
    @OneToMany(mappedBy="student")
    private Set<Report> report;
    
    @OneToMany(mappedBy="student")
    private Set<Response> response;

 

    public int getStudentId() {
        return studentId;
    }

 

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

 

    public String getName() {
        return name;
    }

 

    public void setName(String name) {
        this.name = name;
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

 


    public String getCity() {
        return city;
    }

 

    public void setCity(String city) {
        this.city = city;
    }

 

    public String getState() {
        return state;
    }

 

    public void setState(String state) {
        this.state = state;
    }

 

    public String getQualification() {
        return qualification;
    }

 

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

 

    public String getYearCompletion() {
        return yearCompletion;
    }

 

    public void setYearCompletion(String yearCompletion) {
        this.yearCompletion = yearCompletion;
    }

 

    public Set<Report> getReport() {
        return report;
    }

 

    public void setReport(Set<Report> report) {
        this.report = report;
    }

 

    public Set<Response> getResponse() {
        return response;
    }

 

    public void setResponse(Set<Response> response) {
        this.response = response;
    }

 

 

    public Student(int studentId, String name, String email, String password, String phoneNo, LocalDate dob,
            String city, String state, String qualification, String yearCompletion, Set<Report> report,
            Set<Response> response) {
        super();
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.dob = dob;
        this.city = city;
        this.state = state;
        this.qualification = qualification;
        this.yearCompletion = yearCompletion;
        this.report = report;
        this.response = response;
    }

 

    public LocalDate getDob() {
        return dob;
    }

 

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

 

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

 

    
    
    

 

}