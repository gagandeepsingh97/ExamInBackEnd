package com.lti.repository;

import java.util.ArrayList;
import java.util.List;

import com.lti.entity.Question;

public interface QuestionRepository {

//	int getSubjectIdFromNameAndLevel(int subjectName, int subjectLevel);
	List<Question> getQuestionBySubjectId(int subjectId);
	

}
