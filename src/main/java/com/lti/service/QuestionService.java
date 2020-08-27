package com.lti.service;

import java.util.List;

import com.lti.dto.GetQuestionDto;
import com.lti.entity.Question;

public interface QuestionService {

	List<Question> getQuestionService(int subjectId);
	void saveAnswerService(int studentId, int subjectId, List<Integer> responses);

}
