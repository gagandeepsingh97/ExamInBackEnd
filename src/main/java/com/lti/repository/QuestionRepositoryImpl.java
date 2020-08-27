package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Question;
import com.lti.entity.Report;
import com.lti.entity.Response;
import com.lti.entity.Student;
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
//	        
//		Subject subject = this.entityManager.find(Subject.class,subjectId);
//		
//		String q1 = "from Question where subject =: x";
//		Query qqq = this.entityManager.createQuery(q1).setParameter("x",subject);
//		List<Question> questions = (List<Question>)qqq.getResultList();
	        
//	        String sql = "select ques from Question ques where subject.subjectId = :sub";
//	        TypedQuery<Question> qry = entityManager.createQuery(sql, Question.class);
//	        qry.setParameter("sub", subjectId);
//	        List<Question> questions = qry.getResultList();
//	        return questions;


//		List<Question> questionList= entityManager.createQuery("select q from Question q where q.subjectId=:subId").
//				setParameter("subId",subjectId).
//				getResultList();
//		return questionList;
		
	}
	
	
	@Override
	@Transactional
	public void saveAnswerRepo(int sid, int subid, List<Integer> responsesList) {
		
//		insert query 
		
		System.out.println("Response List" + responsesList.size());
		Student student = this.entityManager.find(Student.class,sid);
		Subject subject = this.entityManager.find(Subject.class,subid);
		String q1 = "from Question where subject =: x";
		Query qqq = this.entityManager.createQuery(q1).setParameter("x",subject);
		List<Question> questions = (List<Question>)qqq.getResultList();
		
		Report report = new Report();
		report.setStudent(student);
		report.setPassingStatus(false);
		report.setSubject(subject);
		report.setnAttempt(1);
		report.setMarks(0);
		this.entityManager.merge(report);
//		this.entityManager.persist(report);
		
		String q2 = "from Report where subject=: x AND student =: y";
		Query query = this.entityManager.createQuery(q2).setParameter("x",subject).setParameter("y",student);
		List<Report> report1 = (List<Report>) query.getResultList();
		
		System.out.println("QuestionSize:" + questions.size());
		for(int i = 0; i < 10; i++)
		{	
		Response response = new Response();
		response.setReport(report1.get(0));
		response.setStudent(student); //object
		response.setQuestion(questions.get(i));
		response.setSelectedOption(responsesList.get(i));
		
		this.entityManager.merge(response);
		}
		System.out.println("Saved!");
		
		
//		Subject subject = entityManager.find(Subject.class,subjectId);
//		Student student = entityManager.find(Student.class,studentId);
//		Report dummyReport = new Report();
//		
//		dummyReport.setnAttempt(0);
//		dummyReport.setMarks(0);
//		dummyReport.setPassingStatus(false);
//		dummyReport.setStudent(student);
//		dummyReport.setSubject(subject);
//		
//		
//		
//		entityManager.persist(student);
////		String prevMaxRid = " SELECT MAX(RID) FROM REPORT ";
////        int finalPrevMaxRid = (Integer) this.entityManager.createQuery(prevMaxRid).getSingleResult();
//        String sql = "INSERT INTO REPORT( RID, SID, SUBID, ATTEMPTNO, MARKS, STATUS) VALUES(?, 0, 0, 0, 0, 0)";
//
//        Query insertQuery = this.entityManager.createQuery(sql);
//        int finalRid = finalPrevMaxRid + 1;
//        insertQuery.setParameter(0, finalRid);
//        insertQuery.setParameter(1, studentId);
//        insertQuery.setParameter(2, subjectId); 
//        insertQuery.setParameter(3, 1); ///   attempt no????
//        insertQuery.setParameter(4, 0);
//        insertQuery.setParameter(5, 0);
//        insertQuery.executeUpdate();
//        String maxResponseid = " SELECT MAX(RID) FROM REPORT ";
//        int responseId = (Integer) this.entityManager.createQuery(maxResponseid).getSingleResult();
//
//       return responseId;
//		String sql = "insert into Report(studentId, subjectId, attemptNo, marks, status) values (0, 0, 0, 0, 0)";
//		 UPDATE RESPONSE SET SELECTED_OPTION = 2
//			     WHERE RESPONSE.QUESID = (
//			             SELECT QUESID FROM QUESTION
//			             WHERE SUBJECTID = 1
//			             AND QUESTIONNUMBER = 1 )
//			     AND RID = 1
//			     AND SID = 1;
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