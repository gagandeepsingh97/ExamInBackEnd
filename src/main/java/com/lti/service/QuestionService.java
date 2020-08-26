package com.lti.service;

import java.util.List;

import com.lti.dto.GetQuestionDto;
import com.lti.entity.Question;

public interface QuestionService {

	List<Question> getQuestionService(int subjectId);

}
