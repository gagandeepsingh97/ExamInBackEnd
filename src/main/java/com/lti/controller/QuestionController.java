package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.StudentController.Status;
import com.lti.dto.GetQuestionDto;
import com.lti.entity.Question;
import com.lti.entity.Student;
import com.lti.service.QuestionService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
    @PostMapping(path="/getQuestion")//, consumes ="application/json", produces="application/json")
    public List<Question> getQuestion(@RequestBody int subjectId) {
    	
    	List<Question> questionList = questionService.getQuestionService(subjectId);
    	return questionList;
    	
    }
    @PostMapping(path="/saveAnswer")//, consumes ="application/json", produces="application/json")
    public void saveAnswer(@RequestBody int[] responses) {
    	for(int i = 0; i < 2; i++) {
    	System.out.println(responses[i]);
    	}
//    	List<Question> questionList = questionService.getQuestionService(subjectId);
//    	return questionList;
    	
    }
}
