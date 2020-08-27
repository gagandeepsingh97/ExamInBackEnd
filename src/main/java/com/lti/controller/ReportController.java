package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.StudentController.LoginStatus;
import com.lti.controller.StudentController.Status;
import com.lti.dto.CalculateMarksDto;
import com.lti.dto.ReportDto;
import com.lti.entity.Student;
import com.lti.service.ReportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@RequestMapping(path="/calculateMarks",method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public int calculateMarks(@RequestBody CalculateMarksDto calculateMarksDto) {
		//System.out.println(calculateMarksDto.getCredentials()[0]);
		int i = reportService.calulateMarksService(calculateMarksDto.getStudentId(), calculateMarksDto.getSubjectId() );
		
		return i;
		
	}
	
	@PostMapping(path="/getReportOfAStudent")//when student will finish exam 
	public List<ReportDto> getReportOfAStudent(@RequestBody int studentId)
	{
		List<ReportDto> reports = reportService.getReportOfAStudent(studentId);
		return reports;
	}
	
	
}