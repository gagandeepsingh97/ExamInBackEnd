package com.lti.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.lti.entity.Question;
import com.lti.entity.Subject;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
//	public int getSubjectIdFromNameAndLevel(int subjectName, int subjectLevel){
//		
//		return 1;
//	}
	@Override
	public List<Question> getQuestionBySubjectId(int subjectId){
	        String sql = "select ques from Question ques where subject.subjectId = :sub";
	        TypedQuery<Question> qry = entityManager.createQuery(sql, Question.class);
	        qry.setParameter("sub", subjectId);
	        List<Question> questions = qry.getResultList();
	        return questions;

//		List<Question> questionList= entityManager.createQuery("select q from Question q where q.subjectId=:subId").
//				setParameter("subId",subjectId).
//				getResultList();
//		return questionList;
		
	}
}
//		System.out.println("line 1 ");
//		String query = "Select q from Question q where q.subjectId =:subId";
//		System.out.println("line 2 real " );
//		TypedQuery<Question> q = entityManager.createQuery(query, Question.class);
//		System.out.println("line 3 ");
//		q.setParameter("subId", subjectId);
//		System.out.println(q.getResultList()+" ");
//		System.out.println("line 2 " +subjectId  + question.getSubjectId());
//		List<Question> questionList = q.getResultList();
//		return questionList;
	
//		TypedQuery<Question> query = entityManager
//				.createQuery("from Question q where q.SUBJECTId =:subId", Question.class)
//				.setParameter("subId", subjectId);
//		List<Question> questionList = query.getResultList();
//		return questionList;
//	}
//
//}
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//		
//
//		String query = " select * from Question q, Subject s where s.subId =1 AND q.questionNumber =1";//"from Question q, Subject s where s.subjectId =:s AND q.questionNumber =:p";
////		select q.correct_option, s.sublevel  from Question q, Subject s where s.subId =1 AND q.questionNumber =1;
//        Query q = (Query)this.entityManager.createNativeQuery(query);
////        q.setParameter("x", subjectId);
////        int prevQuestion = questionNumber + 1;
////        q.setParameter("p", prevQuestion );
//        
//        System.out.println("result list " + q.getResultList());
//        List<Object []> lists = q.getResultList();
//        Object[] q1 = lists.get(0);
//        Object[] s1 = lists.get(0);
//        System.out.println(q1 +" objects" +s1);
//        Question question = new Question();
//        
//        
//        for (Object [] l : lists) {
//        	System.out.println(Arrays.toString(l));
////        	System.out.println(l[0]);
////        	System.out.println(l[2]);
////        	System.out.println(l[3]);
//        	int i = (Integer) l[0];
//        	question.setQuestionId(i);
//        	
//        	
//        }
////        System.out.println("Get ques " + subjectId + prevQuestion);
//
//        return null;
//        
////        return (Question) this.entityManager.createQuery(query);
//		
//	}
//}
//
//	//COLUMN NEEDS TO BE ADDED -------> QUESTION NUMBER    Q1 Q2 Q3 
//
//
//
//
//
//
////return (Question) entityManager
////		.createQuery("select q from QUESTION q where q.subjectID = :subjectId AND q.questionNumber = :prevQuestionNumber")
////		.setParameter("subjectId", subId)
////		.setParameter("prevQuestionNumber", prevQuestionNumber + 1)
//		.getSingleResult();