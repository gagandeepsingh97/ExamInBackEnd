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
import com.lti.service.ReportService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	ReportService reportService;
	
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
    public List<Integer> saveAnswer(@RequestBody ResponseModel responseModel) { // 1 2 3 4 1 2 3 4 1 2
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
    	

    	for(int i = 0; i<responseModel.getAnswes().length; i++) {
    		System.out.println("i" + responseModel.getAnswes()[i]+ " ");
    		System.out.println("r" + r.get(i));
    	}
    	System.out.println("s1" + s1);
    	System.out.println("s2" + s2);
    	questionService.saveAnswerService(s1, s2, r);
    	int i = reportService.calulateMarksService(s1, s2 );
    	System.out.println("marks" + i);
    	List<Integer> sendMarks = new ArrayList<>();
    	sendMarks.add(i);
    	return sendMarks;
    	   }
    	
//    public void updateOptionsOfStudent(int studentId, int subjectId) {
//    	 
//    }
    
    
}
