package com.lti.repository;

import java.util.List;

import com.lti.dto.ReportDto;
import com.lti.entity.Report;

public interface ReportRepository {
	
//	public Report viewReport(int studentId, int subjectId, String attempt); // student id , subject id, attempt 

	List<ReportDto> fetchReportByStudentId(int studentId);  
	
	List<ReportDto> fetchReportBySubjectName(String subjectName);  
	List<ReportDto> fetchReportBySubjectlevel(int subjectLevel);
	List<ReportDto> fetchReportByState(String state);   
	List<ReportDto> fetchReportByCity(String city);
	
	List<ReportDto> fetchReportByMarks(int marks);  
}
