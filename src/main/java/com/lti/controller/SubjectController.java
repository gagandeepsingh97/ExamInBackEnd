package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.SubjectService;

 
@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
    @PostMapping(path="/getExamPaperId"/*, consumes ="application/json", produces="application/json"*/)
    public int getExampaper(@RequestBody String subjectName) {
    	
    	int getExamPaperId = subjectService.getSubjectIdService(subjectName);
    	
    	return getExamPaperId;
    }
}