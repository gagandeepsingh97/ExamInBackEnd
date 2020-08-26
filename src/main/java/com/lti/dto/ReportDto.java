package com.lti.dto;

public class ReportDto {
    private int reportId;
    private String name;
    private String subjectName;
    private int marks;
    private int totalMarks;
    private int subjectLevel;
    public int getResultId() {
        return reportId;
    }
    public void setResultId(int reportId) {
        this.reportId = reportId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
    public int getTotalMarks() {
        return totalMarks;
    }
    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }
    public int getSubjectLevel() {
        return subjectLevel;
    }
    public void setSubjectLevel(int subjectLevel) {
        this.subjectLevel = subjectLevel;
    }
    public ReportDto(int reportId, String name, String subjectName, int marks, int totalMarks, int subjectLevel) {
        super();
        this.reportId = reportId;
        this.name = name;
        this.subjectName = subjectName;
        this.marks = marks;
        this.totalMarks = totalMarks;
        this.subjectLevel = subjectLevel;
    }
    public ReportDto() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
}
 



