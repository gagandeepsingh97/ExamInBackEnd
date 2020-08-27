package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.dto.GetQuestionDto;
import com.lti.entity.Question;
import com.lti.exception.StudentServiceException;
import com.lti.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionRepository questionRepository;
	
	@Override
	public List<Question> getQuestionService(int subjectId) {
		return questionRepository.getQuestionBySubjectId(subjectId);
	}
	
	@Override
	public void saveAnswerService(int studentId, int subjectId, List<Integer> responses) {
		questionRepository.saveAnswerRepo(studentId, subjectId, responses);
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	@Autowired
//	private QuestionRepository questionRepository;
//	
//	public Question getQuestionService(GetQuestionDto getQuestionDto) {
//	try {
//		Question question;
//		int subId = getQuestionDto.getSubjectId();
//		int prevQuesNum = getQuestionDto.getPrevQuestionNumber();
//		question = questionRepository.getQuestionRepo(subId, prevQuesNum);
//		return question;
//	}
//	catch(EmptyResultDataAccessException e) {
//		throw new StudentServiceException("Cannot Login.Incorrect ");
//	}
//		
//	}
//
//}
////try {
////	int id =customerRepo.findByEmailPassword(email, password);
////	Customer cust = customerRepo.findById(id);
////	return cust;
////}
////catch(EmptyResultDataAccessException e) {
////	throw new CustomerServiceException("Cannot Login.Incorrect email/password");
////	
////}
