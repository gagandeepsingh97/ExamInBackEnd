/*package com.lti;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lti.Question;
import com.lti.Subject;
public class QuesSubTest {

	public static void main(String args[])
	{
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	

//	String questionID, SMASTER subjectID, String questionDescr,
//	String option1, String option2,String option3, String option4,
//	Boolean correctAns1, Boolean correctAns2, Boolean correctAns3,Boolean correctAns4,
//	String correctAnsCode
	Subject s1=new Subject();
	//s1.setSID("S1L2");
	s1.setSLevel("L2");
	s1.setSName("S1");
	
	
	
	Question q1=new Question();
	q1.setQuestionID("S1L1Q1");
	q1.setSubjectID("S1L2");
	q1.setSubject(s1);
	q1.setQuestionDescription("what is java");
	q1.setOption1("an object");
	q1.setOption2("an animal");
	q1.setOption3("a place");
	q1.setOption4("a language");
	q1.setCorrectAns1(false);
	q1.setCorrectAns2(false);
	q1.setCorrectAns3(false);
	q1.setCorrectAns4(true);
	q1.setCorrectAnsCode("");
	
	Set<Question> set1 = new HashSet<Question>();        //create a question
	set1.add(q1);

	Session s=factory.openSession();
	Transaction tx=s.beginTransaction();

	s.save(s1);
	s.save(q1);
	tx.commit();
	s.close();
	factory.close();
	}
}
*/