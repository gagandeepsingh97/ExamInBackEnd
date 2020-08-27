package com.lti.entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 

import javax.persistence.OneToMany;
import javax.persistence.Table;

 

@Entity
@Table(name="SUBJECT")
public class Subject {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="SUBID",length=10)
        private int subjectId;
        @Column(name="SUBNAME",length = 10)
        private String subjectName;
        
        @Column(name="SUBLEVEL", length = 10)
        private int subjectLevel;

 
        @OneToMany(cascade= CascadeType.ALL)
        //MAPPED BY MEANS TAKEN THE RIGHT AWAY FROM ANSWERS AND GIVEN TO QUESTION FIELD IN ANSWER.JAVA CLASS
        private Set<Question> question;
        
        @OneToMany(mappedBy="subject")
        private Set<Report> report;

 

        public int getSubjectId() {
            return subjectId;
        }

 

        public void setSubjectId(int subjectId) {
            this.subjectId = subjectId;
        }

 

        public String getSubjectName() {
            return subjectName;
        }

 

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

 

        public int getSubjectLevel() {
            return subjectLevel;
        }

 

        public void setSubjectLevel(int subjectLevel) {
            this.subjectLevel = subjectLevel;
        }

 

        public Set<Question> getQuestion() {
            return question;
        }

 

        public void setQuestion(Set<Question> question) {
            this.question = question;
        }

 

        public Set<Report> getReport() {
            return report;
        }

 

        public void setReport(Set<Report> report) {
            this.report = report;
        }

 

        public Subject(int subjectId, String subjectName, int subjectLevel, Set<Question> question,
                Set<Report> report) {
            super();
            this.subjectId = subjectId;
            this.subjectName = subjectName;
            this.subjectLevel = subjectLevel;
            this.question = question;
            this.report = report;
        }

 

        public Subject() {
            super();
            // TODO Auto-generated constructor stub
        }

 

       
      
}