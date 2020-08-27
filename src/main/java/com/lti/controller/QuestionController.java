package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.QuestionHandle;
import com.lti.dto.ResponseModel;
import com.lti.entity.Question;
import com.lti.service.QuestionService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
    @PostMapping(path="/getQuestion")//consumes ="application/json", produces="application/json")
    public List<QuestionHandle> getQuestion(@RequestBody int subjectId) {
    	System.out.println("Subject ID" + subjectId);
    	List<QuestionHandle> rsList = new ArrayList<>();
    	List<Question> questionList = questionService.getQuestionService(subjectId);
    	for(Question q : questionList) {
    		QuestionHandle qh = new QuestionHandle();
    		qh.setQuestionNumber(q.getQuestionNumber());
    		qh.setQuestionDescription(q.getQuestionDescription());
    		qh.setOption1(q.getOption1());
    		qh.setOption2(q.getOption2());
    		qh.setOption3(q.getOption3());
    		qh.setOption4(q.getOption4());
    		qh.setCorrectOption(q.getCorrectOption());
    		
    		rsList.add(qh);
    	}
    	//return questionList; 
    	return rsList; 
    }
    
    
    @PostMapping(path="/saveAnswer")//, consumes ="application/json", produces="application/json")
    public void saveAnswer(@RequestBody ResponseModel responseModel) { // 1 2 3 4 1 2 3 4 1 2
    	System.out.println(responseModel.getAnswes()[0]);
    	System.out.println(responseModel.getCredentials()[1]);
//    	for(int i = 0; i < 10; i++) {
//    	System.out.println(responses[i]);
//    	}
    	List<Integer> r = new ArrayList();
    	for(int i=0; i < responseModel.getAnswes().length; i++)
    	{
    		r.add(responseModel.getAnswes()[i]);
    	}
    	int s1 = Integer.parseInt(responseModel.getCredentials()[0]);
    	int s2 = Integer.parseInt(responseModel.getCredentials()[1]);
    	questionService.saveAnswerService(s1, s2, r);
    }
//    public void updateOptionsOfStudent(int studentId, int subjectId) {
//    	 
//    }
}
