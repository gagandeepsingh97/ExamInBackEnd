package com.lti.service;

import java.util.List;

import com.lti.dto.ReportDto;

public interface ReportService {

//	List<ReportDto> getReport(int studentId);  
	int calulateMarksService(int studentId, int subjectId);	
}