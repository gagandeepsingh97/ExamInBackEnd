package com.lti.controller;

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
import com.lti.entity.Student;
import com.lti.service.ReportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@RequestMapping(path="/calculateMarks",method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public int calculateMarks(@RequestBody CalculateMarksDto calculateMarksDto) {
	
		int i = reportService.calulateMarksService(calculateMarksDto.getStudentId(), calculateMarksDto.getSubjectId() );
		return i;
		
	}
	
	
	

	
}